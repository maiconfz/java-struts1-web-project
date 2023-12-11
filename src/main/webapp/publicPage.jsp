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
<title>Public Page - MyApp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/style/main.css">
</head>
<body>
    <jsp:include page="incl/header.jsp" />
    <main class="container">
        <h1 class="text-center text-primary mt-5">Public Page - MyApp</h1>

        <div class="row mt-4">
            <div class="col-md-6">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ac augue eu leo posuere hendrerit nec vel sapien. Pellentesque a ipsum hendrerit, elementum lectus eget, convallis enim.</p>
            </div>
            <div class="col-md-6">
                <p>Phasellus sit amet sollicitudin nisl. Suspendisse ac placerat nibh. Suspendisse non pellentesque lectus. Vivamus pulvinar faucibus neque, sed vulputate libero commodo at. Morbi sed placerat diam.</p>
            </div>
        </div>

        <h2 class="mt-4">Heading 2</h2>
        <p>Proin egestas congue mauris sit amet vestibulum. Curabitur varius eget elit vitae mollis. Nunc laoreet sed purus nec lacinia. Vestibulum vitae massa malesuada, laoreet leo a, pellentesque tortor. In efficitur at nibh lacinia lobortis. Etiam feugiat viverra purus sed mattis.</p>

        <h3 class="mt-4">Heading 3</h3>
        <p>In pulvinar eros non ante placerat molestie ut in purus. Curabitur et efficitur augue. Sed feugiat id felis in tristique. Cras porttitor quam sed ornare bibendum.</p>

        <h4 class="mt-4">Heading 4</h4>
        <p>Morbi vel leo sollicitudin, lobortis tortor ut, convallis elit. Nam vestibulum id ipsum sed fringilla. In auctor at arcu et tincidunt. Duis rhoncus, metus vitae aliquet sagittis, tellus massa feugiat ante, sed faucibus massa eros id ex.</p>

        <h5 class="mt-4">Heading 5</h5>
        <p>Vestibulum finibus id nunc eget faucibus. Morbi tristique ante molestie feugiat elementum. Donec tincidunt sodales libero, quis ullamcorper velit tincidunt vitae. Ut fermentum tempus ex, at aliquet mauris iaculis id.</p>

        <h6 class="mt-4">Heading 6</h6>
        <p>Suspendisse nec arcu quis nibh gravida ultrices. Praesent at malesuada nisl, sed porta sapien. Sed pharetra nulla sed quam fringilla auctor. Aenean scelerisque arcu in ornare dictum.</p>
        
        <div class="mt-5">
            <h2 class="text-center text-success">Random Stuff</h2>
            <p>This is some random content. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam.</p>
            <p>Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta.</p>
        </div>
    </main>
    <!-- /container -->
    <jsp:include page="incl/footer.jsp" />

    <!-- Bootstrap JavaScript (jQuery and Bootstrap JS) -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCz5uA+P7xI0pkF00dL4D2C6b+5Kb/p" crossorigin="anonymous"></script>
</body>
</html>