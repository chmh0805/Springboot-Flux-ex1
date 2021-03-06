package com.hyuk.reactorex02;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// Flux : N개 이상의 데이터를 응답 할 때 사용
// Mono : 0 ~ 1개의 데이터를 응답 할 때 사용

@RestController
public class TestController1 {

	@GetMapping("/flux1")
	public Flux<Integer> flux1() {
		return Flux.just(1, 2, 3, 4).log();
	}
	
	@GetMapping(value = "/flux2", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> flux2() {
		return Flux.just(1, 2, 3, 4).delayElements(Duration.ofSeconds(3)).log();
	}
	
	@GetMapping(value = "/flux3", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> flux3() {
		return Flux.interval(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping(value = "/mono1")
	public Mono<Integer> mono1() {
		return Mono.just(1).log();
	}
}
