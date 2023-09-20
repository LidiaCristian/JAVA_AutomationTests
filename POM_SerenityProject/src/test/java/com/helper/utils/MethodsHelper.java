package com.helper.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class MethodsHelper {
	public static int getRandomNumber(int Min, int Max)
	{
	     return (int) (Math.random()*(Max-Min))+Min;
	}

	public static void hoverOverAndClick(WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
}
