<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%if(request.getSession(false).getAttribute("login")==null){ 
	response.sendRedirect("index.jsp");
}
	%>
<%@include file="menu1.jsp" %>
        <div id="main">
               <section id="multiple-column-form">
        <div class="row match-height">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Reservation</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <form class="form">
                                <div class="row">
                                
                                <input hidden type="text" id="idReservation" class="form-control"
                                                placeholder="Note" name="fname-column">
                                    <div class="col-md-6 col-12">
                                    
                                        <div class="form-group">
                                            <label for="first-name-column">Note</label>
                                            <input type="text" id="Note" class="form-control"
                                                placeholder="Note" name="fname-column">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="last-name-column">Type</label>
                                            <input type="text" id="Type" class="form-control"
                                                placeholder="Type" name="lname-column">
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label id="labeldebut" for="email-id-column">Date Debut</label>
                                            <input type="Date" id="dateDebut" class="form-control"
                                                name="email-id-column" placeholder="Date Debut" >
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label id="labelfin" for="email-id-column">Date Fin</label>
                                            <input type="Date" id="dateFin" class="form-control"
                                                name="email-id-column" placeholder="Date Fin" >
                                        </div>
                                    </div>
                                
                                    <div class="col-12 d-flex justify-content-end">
                                        <button id="createReservation" type="submit" class="btn btn-primary me-1 mb-1">Create Reservation</button>
                                      
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
        </div>
