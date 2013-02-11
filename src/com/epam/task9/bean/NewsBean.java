package com.epam.task9.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.epam.task9.database.INewsDao;
import com.epam.task9.model.News;

/**
 * @author Siarhei_Stsiapanau
 * 
 */
public class NewsBean implements Serializable {
    private static final long serialVersionUID = 6955999125391180493L;
    private static final String DEFAULT_LANGUAGE = "en";
    private String name;
    private static final String RESOURCES = "/com/epam/news/resources/ApplicationResource";
    private static final String datePattern = "date.pattern";
    private List<News> newsList = new ArrayList<News>();
    private News news = new News();
    private String lang;
    private Integer[] selectedItems;
    private String dateString;
    private Locale locale;
    private INewsDao newsDao;

    public void list() {
	newsList = newsDao.getAll();
    }

    public void view() {
	if (!newsList.isEmpty()) {
	    news = newsList.get(0);
	}
    }

    public void changeLocale(String lang) {
	if (lang == null || lang.isEmpty()) {
	    this.lang = DEFAULT_LANGUAGE;
	} else {
	    this.lang = lang;
	}
    }

    /**
     * @param newsDao
     *            the newsDao to set
     */
    public void setNewsDao(INewsDao newsDao) {
	this.newsDao = newsDao;
    }

    /**
     * @return the dateString
     */
    public String getDateString() {
	return dateString;
    }

    /**
     * @param dateString
     *            the dateString to set
     */
    public void setDateString(String dateString) {
	this.dateString = dateString;
    }

    /**
     * @return the newsList
     */
    public List<News> getNewsList() {
	return newsList;
    }

    /**
     * @param newsList
     *            the newsList to set
     */
    public void setNewsList(List<News> newsList) {
	this.newsList = newsList;
    }

    /**
     * @return the news
     */
    public News getNews() {
	return news;
    }

    /**
     * @param news
     *            the news to set
     */
    public void setNews(News news) {
	this.news = news;
    }

    /**
     * @return the lang
     */
    public String getLang() {
	return lang;
    }

    /**
     * @param lang
     *            the lang to set
     */
    public void setLang(String lang) {
	this.lang = lang;
    }

    /**
     * @return the selectedItems
     */
    public Integer[] getSelectedItems() {
	return selectedItems;
    }

    /**
     * @param selectedItems
     *            the selectedItems to set
     */
    public void setSelectedItems(Integer[] selectedItems) {
	this.selectedItems = selectedItems;
    }

    /**
     * @return the locale
     */
    public Locale getLocale() {
	return locale;
    }

    /**
     * @param locale
     *            the locale to set
     */
    public void setLocale(Locale locale) {
	this.locale = locale;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }
}
