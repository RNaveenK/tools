package com.rx.tools.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/regex")
@Slf4j
public class RegexController {

	@PostMapping
	public List<String> testRegex(@RequestParam String regex, @RequestParam String text) {
		try {
			log.info("{}--- {}", regex,text);
			List<String> matches = new ArrayList<>();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(text);
			while (matcher.find()) {
				log.info("Result found: {}", matcher.group());
				matches.add(matcher.group());
			}
			return matches;
		} catch (PatternSyntaxException e) {
			return null;
		}
	}

}
