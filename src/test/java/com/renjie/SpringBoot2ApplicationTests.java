package com.renjie;

import com.renjie.config.dataSource.DruidConfig;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2ApplicationTests {

	@Autowired
	private DruidConfig druidConfig;
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
		String username = druidConfig.getUsername();
		System.err.println(username);
	}
}
