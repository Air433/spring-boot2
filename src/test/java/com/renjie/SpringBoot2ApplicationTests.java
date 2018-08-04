package com.renjie;

import com.renjie.common.annotation.TestAspect;
import com.renjie.config.dataSource.DruidConfig;

import javax.annotation.Resource;

import com.renjie.modules.sys.dao.SysUserMapper;
import com.renjie.modules.sys.entity.SysUser;
import com.renjie.modules.sys.service.ShiroService;
import com.renjie.modules.sys.service.SysLogService;
import com.renjie.modules.sys.service.SysUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.concurrent.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2ApplicationTests {

	@Autowired
	private DruidConfig druidConfig;

//	@Resource
//	private UserMapper userMapper;

	@Resource
    private SysUserMapper sysUserMapper;

	@Autowired
	private ShiroService shiroService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysLogService sysLogService;


	@Test
	public void contextLoads() {
		String algorithmName = "md5";
		String username = "air";
		String password = "123";
		String salt1 = username;
		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		int hashIterations = 2;

		//YWlyZTFlNjVjZDkzZmZmZTEzM2JhYmUwMTYwYTc4ZjRiNjc=
		//air0e9590f2a62731198afb4a062e896eaf
//		SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
//		String encodedPassword = hash.toHex();
		System.err.println(salt1+ salt2);
//		System.err.println(encodedPassword);

		for (int i = 0; i < 5; i++) {
			SimpleHash hash = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(salt1 + salt2), hashIterations);
			String encodedPassword = hash.toHex();
			System.err.println(encodedPassword);
		}
		for (int i = 0; i < 5; i++) {
			SimpleHash hash = new SimpleHash(algorithmName, password, salt1 + salt2, hashIterations);
			String encodedPassword = hash.toHex();
			System.err.println(encodedPassword);
		}
	}
	@Test
	public void contextLoads2() {
		String algorithmName = "md5";
		String username = "air";
		String password = "123";
		String salt1 = username;
		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
		int hashIterations = 2;

		//YWlyZTFlNjVjZDkzZmZmZTEzM2JhYmUwMTYwYTc4ZjRiNjc=
		//air0e9590f2a62731198afb4a062e896eaf
		SimpleHash hash = new SimpleHash(algorithmName, password, "YWlyZTFlNjVjZDkzZmZmZTEzM2JhYmUwMTYwYTc4ZjRiNjc=", hashIterations);
		String encodedPassword = hash.toHex();
		System.err.println(salt1+ salt2);
		System.err.println(encodedPassword);
		//tokenHashedCredentials
		//d2e087d82d833022b70adbe2b8f317f9

		//tokenHashedCredentials
		//f8d5230da4892b3e7d695dfe9d05b5fa
		//accountCredentials
		//d2e087d82d833022b70adbe2b8f317f9
	}

	@Test
	public void test(){
		System.err.println(new SecureRandomNumberGenerator().nextBytes().toHex());
		//0c84cb267fee19edcd5aca892aee7f52
		String password=new SimpleHash("MD5","123","air",2).toHex();
		System.err.println(password);
	}
	@Test
	public void test1(){
//		User user = userMapper.selectById(2);
//		System.err.println(user);
//		UserBiz userBiz = userMapper.selectUserBiz(2l);
//		System.err.println(userBiz);
	}
	@Test
    public void test2(){
		Set<String> permissions = shiroService.getUserPermissions(1);
		System.err.println(permissions);

		Set<String> permissions1 = shiroService.getUserPermissions(2);
		System.err.println(permissions1);
	}
	@Test
	public void t3() throws NoSuchMethodException {
		sysLogService.m1();
		sysLogService.m2();
		sysLogService.m3();


	}
	@Test
	public void t5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


		mm(sysLogService.getClass(), "m1");
	}

	private void mm(Class<?> c, String method) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		System.err.println("我是切面哦");
		Method method1 = c.getDeclaredMethod(method);
		method1.invoke(c.newInstance());
	}

	@org.junit.Test
	public void t6() throws IllegalAccessException, InstantiationException {
		Function function = x-> sysUserMapper.selectById(1);
        Object apply = function.apply(null);
        System.err.println(apply);
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();

        Function function2 = x-> new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
    }

    @Test
    public void t99() throws ExecutionException, InterruptedException {
        List<Function> functions = getFunctions();

        List<Callable<String>> callableList = new ArrayList<>();

        for (Function function : functions) {
            Callable callable = ()->{
                return function.apply(null);
            };
            callableList.add(callable);
        }
        List<?> strings = poolExeuter(callableList);
        System.err.println(strings);
    }

    private  List<Function> getFunctions(){
        List<Function> functions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Function<?,String> function = (x)-> {
                System.out.println(">>>" + finalI + "任务启动");
                Date dateTmp1 = new Date();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date dateTmp2 = new Date();
                long time = dateTmp2.getTime() - dateTmp1.getTime();
                System.out.println(">>>" + finalI + "任务终止");
                return finalI + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
            };
            functions.add(function);
        }
        return functions;
    }

    @Test
    public void t10() throws ExecutionException, InterruptedException {
        List<Function<?,String>> functions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Function<?,String> function = (x)-> {
                System.out.println(">>>" + finalI + "任务启动");
                Date dateTmp1 = new Date();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Date dateTmp2 = new Date();
                long time = dateTmp2.getTime() - dateTmp1.getTime();
                System.out.println(">>>" + finalI + "任务终止");
                return finalI + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
            };
            functions.add(function);
        }

        for (Function<?, String> function : functions) {
            Callable<String> callable = ()->{

                return function.apply(null);
            };
        }


        List<Callable<String>> callableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int k = i;
            callableList.add(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println(">>>" + k + "任务启动");
                    Date dateTmp1 = new Date();
                    Thread.sleep(5000);
                    Date dateTmp2 = new Date();
                    long time = dateTmp2.getTime() - dateTmp1.getTime();
                    System.out.println(">>>" + k + "任务终止");
                    return k + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
                }
            });
        }
        List<String> stringList = poolExeuter(callableList);
        System.err.println(stringList);
    }


    @Test
    public void t9() throws ExecutionException, InterruptedException {

	    List<Callable<String>> callableList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int k = i;
            callableList.add(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println(">>>" + k + "任务启动");
                    Date dateTmp1 = new Date();
                    Thread.sleep(5000);
                    Date dateTmp2 = new Date();
                    long time = dateTmp2.getTime() - dateTmp1.getTime();
                    System.out.println(">>>" + k + "任务终止");
                    return k + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
                }
            });
        }
        List<String> stringList = poolExeuter(callableList);
        System.err.println(stringList);
    }

    private <T> List<T> poolExeuter(List<Callable<T>> callableList) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(callableList.size());
        List<Future> list = new ArrayList<>();
        callableList.forEach(x-> list.add(pool.submit(x)));
        pool.shutdown();
        List<T> tList = new ArrayList<>();
        for (Future f : list) {
            System.err.println(">>>" + f.get().toString());
            tList.add((T) f.get());
        }
        return tList;
    }

    @org.junit.Test
    public void t8 () throws ExecutionException, InterruptedException {
            System.out.println("----程序开始运行----");
            Date date1 = new Date();

            int taskSize = 5;
            // 创建一个线程池
            ExecutorService pool = Executors.newFixedThreadPool(taskSize);
            // 创建多个有返回值的任务
            List<Future> list = new ArrayList<Future>();
            for (int i = 0; i < taskSize; i++) {
                Callable c = new MyCallable(i + " ");
                // 执行任务并获取Future对象
                Future f = pool.submit(c);
                // System.out.println(">>>" + f.get().toString());
                list.add(f);
            }
            // 关闭线程池
            pool.shutdown();

            // 获取所有并发任务的运行结果
            for (Future f : list) {
                // 从Future对象上获取任务的返回值，并输出到控制台
                System.out.println(">>>" + f.get().toString());
            }

            Date date2 = new Date();
            System.out.println("----程序结束运行----，程序运行时间【"
                    + (date2.getTime() - date1.getTime()) + "毫秒】");

    }

    class MyCallable implements Callable<Object> {
        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }

        public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date dateTmp1 = new Date();
            Thread.sleep(10000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
        }
    }
}
