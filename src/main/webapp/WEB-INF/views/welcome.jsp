<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
  <head>
    <title>Spring with i18n</title>
  </head>
  <body>
    <p><a href="?mylocale=hu"><spring:message code="language.hungarian" /></a> | <a href="?mylocale=en"><spring:message code="language.english" /></a></p>
    <h1><spring:message code="index.welcome" /></h1>
	<p><spring:message code="index.niceday" /></p>
	<p>${item}</p>
  </body>
</html>