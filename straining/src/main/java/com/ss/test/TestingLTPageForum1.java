package com.ss.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestingLTPageForum1 {
	@FindBy(xpath="//table[@id='threadlisttableid']/tbody[contains(@id,'normalthread_')]")
	public List<WebElement>threads;
}
