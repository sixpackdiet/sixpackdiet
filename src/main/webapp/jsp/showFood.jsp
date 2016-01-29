<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Idea Application</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 

		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/demo.css" />" rel="stylesheet">
		<link href="<c:url value="/resources/css/animate-custom.css" />" rel="stylesheet">

    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
            <div class="codrops-top">
                <a href="">
                    <strong>&laquo; Previous Demo: </strong>Responsive Content Navigator
                </a>
                <span class="right">
                    <a href=" http://tympanus.net/codrops/2012/03/27/login-and-registration-form-with-html5-and-css3/">
                        <strong>Back to the Codrops Article</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1>Foods For <span>Six Pack Abs</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="Ideas" class="animate form">
                            <form:form method="post" modelAttribute="foodItemForm" action="submitFoods"> 
                                <h1>Food Item Details</h1> 
                                <p> 
                                    <form:label path="name" cssClass="uname">Name</form:label>
                                    <form:input cssClass="input"  path="name" type="text" placeholder="${foodItemForm.name}" readonly="true"/> 
                                </p>
                                <p> 
                                    <label for="calories" class="uname" data-icon="u" > Calories </label>
                                    <input id="calories" name="calories" required="required" type="text" value="${foodItemForm.calories}" placeholder="${ideaForm.calories}" readonly="true"/>
                                </p>
                                <p> 
                                    <label for="protein" class="uname" data-icon="u" > Protein </label>
                                    <input id="protein" name="protein" required="required" type="text" value="${foodItemForm.protein}"  readonly="true"/>
                                </p>
                                <p> 
                                    <label for="carbohydrate" class="uname" data-icon="u" > Carbohydrate </label>
                                    <input id="carbohydrate" name="carbohydrate" required="required" type="text" value="${foodItemForm.carbohydrate}" readonly="true"/>
                                </p>
                                	<label for="fat" class="uname" data-icon="u" > Fat </label>
                                    <input id="fat" name="fat" required="required" type="text" value="${foodItemForm.fat}" readonly="true"/> 
								</p> 
                            </form:form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>