package misc;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dhavalchauhan on 5/14/14.
 */
public class HashGenerator {

    public static void main(String args[]){

        HashGenerator hashGenerator = new HashGenerator();
        String appID = "test";
        String title = "test";
        String version = "1.9";

        System.out.println(hashGenerator.computeAppHash(appID,title,version));
    }
    /**
     *
     * @return
     */
    public String computeAppHash(String appId,String version,String title) {
        StringBuffer hashFields = new StringBuffer();
        hashFields.append(appId);
        hashFields.append(version);
        hashFields.append(title);
        String appHashCode = null;
        try {
            appHashCode = generateSha1HashCode(hashFields.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appHashCode;
    }

    /**
     * @param data
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String generateSha1HashCode(String data)
            throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest
                .getInstance(HASH_ALGORITHM_SHA);
        messageDigest.update(data.getBytes());
        byte[] digestData = messageDigest.digest();
        return generateSha1HashCode(digestData);
    }

    /**
     * @param digestData
     * @return
     */
    public static String generateSha1HashCode(byte[] digestData) {
        String result = "";
        char c;
        for (int i = 0; i < digestData.length; i++) {
            c = (char) ((digestData[i] >> 4) & 0xf);
            if (c > 9)
                c = (char) ((c - 10) + 'A');
            else
                c = (char) (c + '0');
            result += c;
            c = (char) (digestData[i] & 0xf);
            if (c > 9)
                c = (char) ((c - 10) + 'A');
            else
                c = (char) (c + '0');
            result += c;
        }
        return result;
    }

    public static final String HASH_ALGORITHM_SHA = "SHA";

}
