public class StringFrameURL {

    String url = "https://pwnmojo.wordpress.com/wp-admin/post.php?post=NUM&action=edit&calypsoify=1&block-editor=1&frame-nonce=255ccac29d&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";

    public static void main(String[] args){

        String url = "https://pwnmojo.wordpress.com/wp-admin/post.php?post=NUM&action=edit&calypsoify=1&block-editor=1&frame-nonce=255ccac29d&origin=https%3A%2F%2Fwordpress.com&environment-id=production&support_user&_support_token";

        String tempURL = "https://wordpress.com/post/pwnmojo.wordpress.com/107";
        String shortUrl = tempURL.substring(tempURL.indexOf("pwnmojo.wordpress.com/"),tempURL.length());
        System.out.println(shortUrl);
        int start = shortUrl.indexOf("/");
        int end = shortUrl.length();
        System.out.println("start"+start+"end"+end);
        String tempCode = shortUrl.substring(start+1,end);
        System.out.println(tempCode);


        System.out.println(tempCode);

        /*
        String number = tempCode.substring(tempCode.indexOf("=")+1,tempCode.length());
        System.out.println(number);
        String newurl = url.replace("NUM",number);
        System.out.println(newurl);

         */



    }
}
