<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Private Page - MyApp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
    <jsp:include page="../incl/header.jsp" />
    <main class="container">
        <h1>Private Page (Default)</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac augue eu leo posuere hendrerit nec vel sapien. Pellentesque a ipsum hendrerit, elementum lectus eget, convallis enim. Phasellus sit amet sollicitudin nisl. Suspendisse ac placerat nibh. Suspendisse non pellentesque lectus. Vivamus pulvinar faucibus neque, sed vulputate libero commodo at. Morbi sed placerat diam. Nullam vestibulum iaculis ante, nec rhoncus ligula efficitur ac. Integer vel risus tortor. Morbi laoreet blandit cursus. Nulla venenatis leo ut risus luctus aliquet. Etiam ut rhoncus risus. Phasellus purus lorem, convallis et varius sed, auctor eu felis. Mauris feugiat metus id quam sodales suscipit. Curabitur id rhoncus metus.</p>
        <h2>Heading 2</h2>
        <p>Proin egestas congue mauris sit amet vestibulum. Curabitur varius eget elit vitae mollis. Nunc laoreet sed purus nec lacinia. Vestibulum vitae massa malesuada, laoreet leo a, pellentesque tortor. In efficitur at nibh lacinia lobortis. Etiam feugiat viverra purus sed mattis. Duis dictum odio sagittis sagittis sollicitudin. Nulla pellentesque tristique aliquet. Pellentesque lobortis diam vel rhoncus dignissim. Sed ac elementum ipsum. Vestibulum viverra quam ac volutpat porta.</p>
        <h3>Heading 3</h3>
        <p>In pulvinar eros non ante placerat molestie ut in purus. Curabitur et efficitur augue. Sed feugiat id felis in tristique. Cras porttitor quam sed ornare bibendum. Vivamus imperdiet rutrum ligula, id feugiat libero molestie vitae. Ut id ligula dignissim, luctus velit eget, malesuada sapien. Morbi a ligula consequat, tempus urna vel, molestie lacus. Cras in metus et diam ornare luctus a sit amet eros. Aenean sodales risus eu neque rutrum malesuada. Vivamus at sodales turpis. Donec dictum dictum massa, sit amet fringilla risus.</p>
        <h4>Heading 4</h4>
        <p>Morbi vel leo sollicitudin, lobortis tortor ut, convallis elit. Nam vestibulum id ipsum sed fringilla. In auctor at arcu et tincidunt. Duis rhoncus, metus vitae aliquet sagittis, tellus massa feugiat ante, sed faucibus massa eros id ex. Vestibulum ac neque maximus, bibendum massa nec, ultricies nisl. Donec pharetra laoreet justo. In ultricies, elit laoreet placerat ornare, enim magna efficitur ex, et aliquet arcu lectus a urna. Suspendisse in vehicula sapien. Suspendisse non augue eget magna rutrum consectetur. Integer sit amet orci molestie, fermentum mauris id, iaculis arcu. Donec ac cursus odio, nec vehicula tellus. Suspendisse potenti.</p>
        <h5>Heading 5</h5>
        <p>Vestibulum finibus id nunc eget faucibus. Morbi tristique ante molestie feugiat elementum. Donec tincidunt sodales libero, quis ullamcorper velit tincidunt vitae. Ut fermentum tempus ex, at aliquet mauris iaculis id. Fusce commodo sapien sit amet eros faucibus, eget aliquam orci rhoncus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Vivamus volutpat tempus luctus.</p>
        <h6>Heading 6</h6>
        <p>Suspendisse nec arcu quis nibh gravida ultrices. Praesent at malesuada nisl, sed porta sapien. Sed pharetra nulla sed quam fringilla auctor. Aenean scelerisque arcu in ornare dictum. Maecenas aliquam nisi vulputate, vehicula nisi ut, sodales nisl. Integer interdum nec nisi vel scelerisque. Integer ornare mi mi, non placerat sem accumsan eget. Nunc in neque quam. Proin commodo velit ut mi eleifend, id luctus metus sollicitudin. Integer rutrum felis ac massa pellentesque egestas. Vivamus malesuada neque a pellentesque gravida. Nunc a hendrerit sapien. Donec et fringilla ipsum, quis sagittis sem. Integer metus tellus, scelerisque sed nisl quis, dignissim consequat odio. Fusce nec nulla non est semper tempus eu vel mauris. Curabitur et aliquam libero.</p>
    </main>
    <!-- /container -->
    <jsp:include page="../incl/footer.jsp" />
</body>
</html>