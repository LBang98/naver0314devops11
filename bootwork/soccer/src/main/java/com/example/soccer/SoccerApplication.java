package com.example.soccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class SoccerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerApplication.class, args);
	}

}
@RestController
@CrossOrigin(origins = "*")
class FootballApiController {

	private static final String API_URL = "https://api-football-v1.p.rapidapi.com/v3/fixtures";
	private static final String API_KEY = "your_api_key_here"; // 환경 변수나 설정 파일에서 로드하세요.

	@GetMapping("/api/fixtures")
	public String getFixtures() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(API_URL))
				.header("x-rapidapi-key", API_KEY)
				.header("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
				.GET()
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}
