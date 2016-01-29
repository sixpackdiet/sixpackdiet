<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Six Pack Diet</title>
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
                <h1>Food Item For <span>Six Pack Abs</span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="Ideas" class="animate form">
                            <form:form method="post" modelAttribute="foodItemForm" action="submitFoodItem"> 
                                <h1>Enter Food Details</h1> 
                                <p> 
                                    <form:label path="name" cssClass="uname">Name</form:label>
                                    <form:input cssClass="input" path="name" type="text" placeholder="Name" /> 
                                </p>
                                <p> 
                                    <label for="calories" class="uname" data-icon="u" > Calories </label>
                                    <form:input cssClass="input" path="calories" type="text" placeholder="Calories" /> 
                                </p>
                                <p> 
                                    <label for="quantity" class="uname" data-icon="u" > Quantity </label>
                                    <form:input cssClass="input" path="quantity" type="text" placeholder="Quantity" /> 
                                </p>
                                <p>
                                    <label for="measurementUnit" class="uname" data-icon="u" > Measurement Unit </label>
									<%-- <form:input cssClass="input" path="measurementUnit" type="text" placeholder="Measurement Unit" /> --%> 
									<form:select cssClass="input" path="measurementUnit">
    									<form:options items="${measurementList}" />
									</form:select>
                                </p>
                                <p> 
                                    <label for="protein" class="uname" data-icon="u" > Protein </label>
                                    <form:input cssClass="input" path="protein" type="text" placeholder="Protein" /> 
                                </p>
                                <p> 
                                    <label for="carbohydrate" class="uname" data-icon="u" > Carbohydrate </label>
                                    <form:input cssClass="input" path="carbohydrate" type="text" placeholder="Carbohydrate" /> 
                                </p>
                                <p> 
                                    <label for="fat" class="uname" data-icon="u" > Fat </label>
                                    <form:input cssClass="input" path="fat" type="text" placeholder="Fat" /> 
                                    
                                </p>
                                 <p class="login button"> 
                                    <input type="submit" value="Add Food Item" /> 
								</p> 

                            </form:form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>