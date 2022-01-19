
$(document).ready(function(){

//Affichage User
  function Affichage(data) 
  {
	 for (var i=0; i<data.length; i++) {
	
            var row = $('<tr  > <td >' 
            + data[i].id+ '</td> <td >' 
            + data[i].fullName + '</td><td>' 
            + data[i].username + '</td><td>'
            + data[i].password + '</td><td>'
            + data[i].email + '</td><td>'
            + data[i].city + '</td><td>'
            + data[i].state + '</td><td>'
            + data[i].level + '</td><td>'
            
            +'<button  class="btn btn-primary me-1 mb-1 deleteUser" type="submit" > Delete </button>&nbsp;'+ 
            
             '<button   class="btn btn-primary me-1 mb-1 update" type="submit" > Edit </button>'+ 
            
            '</td></tr>');
            $('#UserTable').append(row);
            
        }
        
        //Delete
         $('.deleteUser').click(function ()
         
          {

      var id =$(this).parents().eq(1).children("td").html();
      
  
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "delete",id: id},
            
            success: function (data) {
	
                if(data.length>0)  
                
                {
	             console.log(id);
	             
	            $('#UserTable').empty();
	          
               Affichage(data);
                
                }
               
            },
            
            error: function (jqXHR, textStatus, errorThrown)
            
             {
	
             console.log("not working");
             
             
            }
            
        });
    });
    
    
        //Update
        
        $('.update').click(function ()
         
          {
	      
	    $("#createUser").html("Update");
	    

         $('#iduser').val($(this).parents().eq(1).children("td").eq(0).html()) ;
        var username = $('#username').val($(this).parents().eq(1).children("td").eq(2).html());
        var password =  $('#password').val($(this).parents().eq(1).children("td").eq(3).html());
        var fullname = $('#fullname').val($(this).parents().eq(1).children("td").eq(1).html());
        var level = $('#level').val($(this).parents().eq(1).children("td").eq(7).html());
        var state = $('#state').val($(this).parents().eq(1).children("td").eq(6).html());
        var email = $('#email').val($(this).parents().eq(1).children("td").eq(4).html());
        var city = $('#city').val($(this).parents().eq(1).children("td").eq(5).html());
        
    }); 
}

    $('#login').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "login",username: username, password: password},
            
            success: function (data) {
	            console.log(data);
                if(data===true) $(location).attr('href','dashboard.jsp');
               
            },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
            }
            
        });
    });
    
//Create and update +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
      $('#createUser').click(function () {
	    var id = $('#iduser').val();
        var username = $('#username').val();
        var password = $('#password').val();
        var fullName = $('#fullName').val();
        var level = $('#level').val();
        var state = $('#state').val();
        var email = $('#email').val();
        var city = $('#city').val();
       
        if( $("#createUser").html()==="Create Account") {
	
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "createAccount",username: username, password: password ,fullname: fullname , email:email ,level:level , state:state ,city:city },
            
            success: function (data) {
	            $('#UserTable').empty();
                 Affichage(data);
             
            },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
            }
            
        });
	
}


if( $("#createUser").html()==="Update"){

	 $.ajax({
		 
	
            type: "POST",
            url: "UserController",
            data: {op: "update", id:id , username: username, password: password ,fullName: fullName , email:email ,level:level , state:state ,city:city },
            
            success: function (data) {
	
	            $('#UserTable').empty();
                 Affichage(data);
                 $("#createUser").html("Create Account");
            },
            
            error: function (jqXHR, textStatus, errorThrown) {
             console.log("not working");
             
            }
            
        });
        
}

    });
    
    
     

 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    
    $('#EditUser').click(function () {
      var id = $('#IdUser').val();
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "delete",id: id},
            
            success: function (data) {
	
                if(data===true)  $(location).attr('href','dashboard.jsp');
               
            },
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
             
            }
            
        });
    });
    
      $('#createReservation').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "login",username: username, password: password},
            
            success: function (data) {
                if(data===true) $(location).attr('href','dashboard.jsp');
               
            },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
            }
            
        });
    });
    

  


 $.ajax({
    url: 'http://localhost:8081/Reserv_salles/UserController',
    dataType: 'json',
    success: Affichage,
    error: function(jqXHR, textStatus, errorThrown)
    {
     //   alert('Error: tsat tsat ' + textStatus + ' - ' + errorThrown);
    }
});














//Gestion Salles +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    // Affichage Salles 
    
    
  function AffichageSalles(data) 
  {
	 for (var i=0; i<data.length; i++) {
	
            var row = $('<tr  > <td >' 
            + data[i].id+ '</td> <td >' 
            + data[i].name + '</td><td>' 
            + data[i].capacity + '</td><td>'
            + data[i].type + '</td><td>'
            
            +'<button  class="btn btn-primary me-1 mb-1 deleteSalle" type="submit" > Delete </button>&nbsp;'+ 
            
             '<button   class="btn btn-primary me-1 mb-1 updateSalle" type="submit" > Edit </button>'+ 
            
            '</td></tr>');
            
            $('#SalleTable').append(row);
            
        }
        
        //Delete
        
         $('.deleteSalle').click(function ()
         
          {

      var id =$(this).parents().eq(1).children("td").html();
      
  
        $.ajax({
	
            type: "POST",
            
            url: "SalleController",
            
            data: {op: "delete",id: id},
            
            success: function (data) {
	
                if(data.length>0)  
                
                {
	             console.log(id);
	             
	            $('#SalleTable').empty();
	          
               AffichageSalles(data);
                
                }
               
            },
            
            error: function (jqXHR, textStatus, errorThrown)
            
             {
	
             console.log("not working");
             
             
            }
            
        });
    });
    
    
        //Update
        
        $('.updateSalle').click(function ()
         
          {
	      
	    $("#createSalle").html("Update Salle");
	    

            $('#idSalle').val($(this).parents().eq(1).children("td").eq(0).html()) ;
        var name = $('#name').val($(this).parents().eq(1).children("td").eq(1).html());
        var capacity = $('#capacity').val($(this).parents().eq(1).children("td").eq(2).html());
        var type = $('#type').val($(this).parents().eq(1).children("td").eq(3).html());
      
         
        
    }); 
}

    
    
    //Create Salle -----------------
    
   $('#createSalle').click(function () {
	    var id = $('#idSalle').val();
        var name = $('#name').val();
        var capacity = $('#capacity').val();
        var type = $('#type').val();
        var nReservation = $('#nReservation').val();
         
       
       
       if($("#createSalle").html()==="Create Salle") {
	   $.ajax({
	
            type: "POST",
            url: "SalleController",
            data: {op: "add" , name: name, capacity: capacity ,type: type  },
            
            success: function (data) {
	
	             $('#SalleTable').empty();
                 AffichageSalles(data);

                           },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
             
            }
            
        });
	
	
}


if($("#createSalle").html()==="Update Salle"){
	
	  $.ajax({
	
            type: "POST",
            
            url: "SalleController",
            
            data: {op: "update", id: id , name: name, capacity: capacity ,type: type},
            
            success: function (data) 
            
            {
	
             
	             $('#SalleTable').empty();
	             
                 AffichageSalles(data);
                 
                 $("#createSalle").html("Create Salle");
                
                           },
                           
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
             
            }
            
        });
}

     
    });
  
  

  
  
  
  
  $.ajax({
    url: 'http://localhost:8081/Reserv_salles/SalleController',
    dataType: 'json',
    success: AffichageSalles,
    error: function(jqXHR, textStatus, errorThrown)
    {
     //   alert('Error: tsat tsat ' + textStatus + ' - ' + errorThrown);
    }
});

  
  
  
  
  
  //
  
  
  
  
  //Gestion Reservation +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    // Affichage Reservation 
    
    
  function AffichageReservation(data) 
  {
	 for (var i=0; i<data.length; i++) {
	
            var row = $('<tr><td >' 
            + data[i].id+ '</td> <td >' 
            + data[i].note + '</td><td>' 
            + data[i].type + '</td><td>'
            + data[i].salle + '</td><td>
            + data[i].client + '</td><td>
            + data[i].creneaux + '</td><td>
            
            +'<button  class="btn btn-primary me-1 mb-1 deleteRes" type="submit" > Delete </button>&nbsp;'+ 
            
             '<button   class="btn btn-primary me-1 mb-1 updateRes" type="submit" > Edit </button>'+ 
            
            '</td></tr>');
            
            $('#ReservationTable').append(row);
            
        }
        
        //Delete
        
         $('.deleteRes').click(function ()
         
          {

      var id =$(this).parents().eq(1).children("td").html();
      
  
        $.ajax({
	
            type: "POST",
            
            url: "SalleController",
            
            data: {op: "delete",id: id},
            
            success: function (data) {
	
                if(data.length>0)  
                
                {
	             console.log(id);
	             
	            $('#ReservationTable').empty();
	          
               AffichageReservation(data);
                
                }
               
            },
            
            error: function (jqXHR, textStatus, errorThrown)
            
             {
	
             console.log("not working");
             
             
            }
            
        });
    });
    
    
        //Update
        
        $('.updateRes').click(function ()
         
          {
	      
	    $("#createReservation").html("Update Salle");
	    

            $('#idReservation').val($(this).parents().eq(1).children("td").eq(0).html()) ;
        var Note = $('#Note').val($(this).parents().eq(1).children("td").eq(1).html());
        var Type = $('#Type').val($(this).parents().eq(1).children("td").eq(2).html());
        var Salle = $('#Salle').val($(this).parents().eq(1).children("td").eq(3).html());
        var Client = $('#Client').val($(this).parents().eq(1).children("td").eq(4).html());
        var Company = $('#Company').val($(this).parents().eq(1).children("td").eq(5).html());
         var Creneaux = $('#Creneaux').val($(this).parents().eq(1).children("td").eq(6).html());
      
         
        
    }); 
}

    
    
    //Create Salle -----------------
    
   $('#createReservation').click(function () {
	
         
         
         
       var id =    $('#idReservation').val() ;
        var Note = $('#Note').val();
        var Type = $('#Type').val();
        var Salle = $('#Salle').val();
        var Client = $('#Client').val();
        var Company = $('#Company').val();
        var Creneaux = $('#Creneaux').val();
       
       
       if($("#createReservation").html()==="Create Reservation") {
	   $.ajax({
	
            type: "POST",
            url: "SalleController",
            data: {op: "add" ,   },
            
            success: function (data) {
	
	             $('#ReservationTable').empty();
                 AffichageReservation(data);

                           },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
             
            }
            
        });
	
	
}


if($("#createReservation").html()==="Update Reservation"){
	
	  $.ajax({
	
            type: "POST",
            
            url: "SalleController",
            
            data: {op: "update", id: id , name: name, capacity: capacity ,type: type},
            
            success: function (data) 
            
            {
	
             
	             $('#ReservationTable').empty();
	             
                 AffichageReservation(data);
                 
                 $("#createSalle").html("Create Salle");
                
                           },
                           
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
             
            }
            
        });
}

     
    });
  
  

  
  
  
  
  $.ajax({
    url: 'http://localhost:8081/Reserv_salles/ReservationController',
    dataType: 'json',
    success: AffichageReservation,
    error: function(jqXHR, textStatus, errorThrown)
    {
     //   alert('Error: tsat tsat ' + textStatus + ' - ' + errorThrown);
    }
});

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

});



  










    
  