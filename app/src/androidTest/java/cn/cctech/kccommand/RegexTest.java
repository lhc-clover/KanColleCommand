package cn.cctech.kccommand;

import android.test.AndroidTestCase;

public class RegexTest extends AndroidTestCase {

    public void testRegexMatch() {
        String url = "http://203.104.209.39/get_world_id/sth.do?a=1";
        String regex = ".*203\\.104\\.\\d{1,3}\\.\\d{1,3}.*";
        assertTrue(url.matches(regex));
    }
}
