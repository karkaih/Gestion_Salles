$(document).ready(function(){

    $('#login').click(function () {
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
    
    
      $('#createUser').click(function () {
	
        var username = $('#username').val();
        var password = $('#password').val();
         var fullname = $('#fullname').val();
        var level = $('#level').val();
         var birthdate = $('#birthdate').val();
        var state = $('#state').val();
         var email = $('#email').val();
        var city = $('#city').val();
       
        $.ajax({
	
            type: "POST",
            url: "UserController",
            data: {op: "createAccount",username: username, password: password ,fullname: fullname , email:email ,level:level ,birthdate:birthdate , state:state ,city:city },
            
            success: function (data) {
                if(data===true) $(location).attr('href','utilisateur.jsp');
               
            },
            
            error: function (jqXHR, textStatus, errorThrown) {
	
             console.log("not working");
            }
            
        });
    });
    
    
      $('#createSalle').click(function () {
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
    
    
    //Affichage

$(Affichage.jsp).ready(function() {
    editor = new $.fn.dataTable.Editor( {
	url: 'http://localhost:8081/Reserv_salles/UserController',
    dataType: 'json',
        table: "#UserTable",
        fields: [ {
                label: "Id:",
                name:  "id"
            }, 
          {
                label: "Username:",
                name:  "username"
            }, 
            {
                label: "Password:",
                name:  "password"
            }, 
            {
                label: "Level:",
                name:  "level"
            }, 
            {
                label: "FullName:",
                name:  "fullname"
            }, 
            {
                label: "City:",
                name:  "city"
            }, 
            {
                label: "State:",
                name:  "state"
            }, 
        ]
    } );
 
    $('#UserTable').DataTable( {
        dom: "Bfrtip",
        ajax: "UserController.jsp",
        columns: [
            { data: "id" },
            { data: "username" },
             { data: "password" },
            { data: "email" },
             { data: "city" },
            { data: "state" },
             { data: "level" },
        ],
        select: true,
        buttons: [
            { extend: "create", editor: editor },
            { extend: "edit",   editor: editor },
            { extend: "remove", editor: editor }
        ]
    } );
} );
    
  

    
});
