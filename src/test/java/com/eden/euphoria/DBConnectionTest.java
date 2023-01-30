/*
 * ┌───────────────────────────────────────────────────────────────────┐
 * │ Copyright (c) 2023년 1월 30일 송민우 All rights reserved.          │
 * └───────────────────────────────────────────────────────────────────┘
 */

/*
Date Created : 2023-01-30
Code Author : 송민우
Creation Time : 오후 4:05
Purpose : 
*/

package com.eden.euphoria;
import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/applicationContext.xml" })
public class DBConnectionTest {

    @Inject
    private DataSource ds;

    @Test
    public void testConnection() {

        try (Connection con = ds.getConnection()) {

            System.out.println("\nDB연결 성공 !!\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
