package com.target.myretailapi.service.retail;

import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = { "product-api=http://redsky.target.com" })
public class RetaiServiceTest {

}
