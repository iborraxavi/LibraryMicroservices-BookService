package com.certiorem.librarymicroservicesproject.constants;

public class BookPathConstants {
	
	// URL path
	public static final String BOOK_SERVICE_SAVE = "/book/save";
	public static final String BOOK_SERVICE_READ = "/book/read";
	public static final String BOOK_SERVICE_DELETE = "/book/delete";
	public static final String BOOK_SERVICE_ALL_BOOKS = "/book/all";
	public static final String BOOK_SERVICE_GET_BY_EDITORIAL = "/book/by-editorial";
	public static final String BOOK_SERVICE_GET_BY_GENRE = "/book/by-genre";
	
	// URL Params names
	public static final String BOOK_SERVICE_ID_PARAM_NAME = "id";
	public static final String BOOK_SERVICE_EDITORIAL_ID_PARAM_NAME = "editorialId";
	public static final String BOOK_SERVICE_GENRE_ID_PARAM_NAME = "bookGenreId";
	
	// URL Params path
	public static final String BOOK_SERVICE_ID_PARAM = "?id={" + BOOK_SERVICE_ID_PARAM_NAME + "}";
	public static final String BOOK_SERVICE_EDITORIAL_ID_PARAM = "?editorialId={" + BOOK_SERVICE_EDITORIAL_ID_PARAM_NAME + "}";
	public static final String BOOK_SERVICE_GENRE_ID_PARAM = "?bookGenreId={" + BOOK_SERVICE_GENRE_ID_PARAM_NAME + "}";
	
}
