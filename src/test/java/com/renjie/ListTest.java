package com.renjie;

import com.renjie.modules.sys.entity.SysRole;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Author oyg
 * @Date 2018/8/19/12:21
 */
public class ListTest {

    @Test
    public void t1(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);

        SysRole role = new SysRole();
         SysRole sysRole = role;

        role = null;

        System.err.println(sysRole);
        System.err.println(role);
        Iterator iterator = linkedList.iterator();

        iterator.hasNext();
        new ArrayList<>().iterator();
    }

    @Test
    public void t2() throws IOException {
        String username = "admin";
        String password = "admin";
         final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String json = "{\"username\":\""+username+"\",\"password\":\""+password+"\"}";
        RequestBody body = RequestBody.create(JSON, json);
        String url = "http://localhost:8099/sys/login";
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        System.err.println(response.body().toString());
    }
}
