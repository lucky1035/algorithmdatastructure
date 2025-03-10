import lombok.var;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        String apiKey = System.getenv("1e2fc66e9131440892d5a1deac65c95e"); // 从环境变量中读取API Key
        String appId = "YOUR_APP_ID"; // 替换为实际的应用ID
        String url = String.format("https://dashscope.aliyuncs.com/api/v1/apps/%s/completion", appId);

        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // 创建请求体
            String jsonInputString = "{\"input\": {\"prompt\": \"美食推荐\", \"memory_id\": \"YOUR_MEMORY_ID\"}, \"parameters\": {}, \"debug\": {}}";

            // 发送请求
            con.setDoOutput(true);
            try (var wr = new java.io.OutputStreamWriter(con.getOutputStream())) {
                wr.write(jsonInputString);
            }

            // 读取响应
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 成功
                var in = new Scanner(con.getInputStream()).useDelimiter("\\A");
                System.out.println(in.hasNext() ? in.next() : "");
            } else {
                System.out.println("Request failed with status code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}