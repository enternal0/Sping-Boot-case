package com.dan.boot;

import com.dan.boot.component.ExampleBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExampleBeanTest {
        @Autowired
        private ExampleBean exampleBean;


        @Test
        public void test1() {
            Assert.assertEquals("jack", exampleBean.getName());
        }


        @Test
        public void test2() {
            Assert.assertEquals("jack2", exampleBean.getName());
        }
}
