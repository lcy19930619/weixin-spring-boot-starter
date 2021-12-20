package net.jlxxw.wechat.dto.message;

import net.jlxxw.wechat.base.BaseTest;
import net.jlxxw.wechat.response.WeChatMessageResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * @author chunyang.leng
 * @date 2021-12-18 6:18 下午
 */
public class ShortVideoMessageTest extends BaseTest {
    @Test
    public void convertTest() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("mock/data/xml/ShortVideoMessage.xml");
        File file = classPathResource.getFile();
        ShortVideoMessage message = readXmlData(file, ShortVideoMessage.class);
        Assert.assertNotNull(message);
    }

    @Test
    public void responseTest() throws IOException {
        String xmlData = readXmlData("mock/data/xml/ShortVideoMessage.xml");
        WeChatMessageResponse response = nettyMessageSend(xmlData, WeChatMessageResponse.class);
        Assert.assertNotNull(response);


        WeChatMessageResponse.Video video = response.getVideo();
        Assert.assertNotNull(video);

        String mediaId = video.getMediaId();
        String title = video.getTitle();
        String description = video.getDescription();

        Assert.assertEquals("预期的值为mediaId，但发现的值为:"+mediaId,"mediaId",mediaId);
        Assert.assertEquals("预期的值为title，但发现的值为:"+title,"title",title);
        Assert.assertEquals("预期的值为description，但发现的值为:"+description,"description",description);


    }
}
