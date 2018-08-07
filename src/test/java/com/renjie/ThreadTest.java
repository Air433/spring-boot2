package com.renjie;

import com.renjie.modules.sys.entity.SysMenu;
import com.renjie.modules.sys.entity.SysRole;
import com.renjie.modules.sys.entity.SysUser;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @Author oyg
 * @Date 2018/8/4/09:23
 */
public class ThreadTest {

    @org.junit.Test
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

    @org.junit.Test
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

        int taskSize = 10;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable<String> c = new MyCallable(i + " ");
            // 执行任务并获取Future对象
//            try {

            Future<String> f = pool.submit(c);
            list.add(f);
//            }catch (Exception e){
//                System.err.println("进入 pool.submit(c)异常");
//                e.printStackTrace();
//            }

            // System.out.println(">>>" + f.get().toString());

        }
        // 关闭线程池
        pool.shutdown();

        List<String> result = new ArrayList<>();
        // 获取所有并发任务的运行结果
        for (Future<String> f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            try {
                System.out.println(">>>" + f.get().toString());
                result.add(f.get());
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");

    }

    class MyCallable<T> implements Callable {
        private String taskNum;

        MyCallable(String taskNum) {
            this.taskNum = taskNum;
        }
        @Override
        public T call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date dateTmp1 = new Date();
            if (taskNum.equals("3 ")){
                throw new Exception();
            }
            Thread.sleep(10000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return (T)(taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】");
        }
    }

    @Test
    public void t2(){

        SysUser sysUser= new SysUser();
        SysRole sysRole = new SysRole();
        Object coc = coc(sysRole, sysUser);

        System.err.println(coc);
    }

    private <T, K> T coc(T t, K c){
        return (T)c;
    }

    @Test
    public void t3(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("苏杉杉");
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("管理者");

        List<SysMenu> sysMenus = new ArrayList<>();

        TestResponse<SysMenu, SysUser, SysRole> testResponse = add(sysMenus, sysUser, sysRole);

        List<SysMenu> menuList = testResponse.gettList();

        SysUser k = testResponse.getK();

        SysRole m = testResponse.getM();

        TestResponse<SysMenu, Object, SysRole> add = add(sysMenus, null, sysRole);

    }

    private <T,K,M> TestResponse<T,K,M> add(List<T> ts, K k, M m){

        TestResponse testResponse = new TestResponse();

        testResponse.settList(ts);
        testResponse.setK(k);
        testResponse.setM(m);
        return testResponse;
    }


}
