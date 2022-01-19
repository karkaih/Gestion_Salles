<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Mazer Admin Dashboard</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="mazer-main/dist/assets/css/bootstrap.css">

    <link rel="stylesheet" href="mazer-main/dist/assets/vendors/iconly/bold.css">

    <link rel="stylesheet" href="mazer-main/dist/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="mazer-main/dist/assets/vendors/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" href="mazer-main/dist/assets/css/app.css">
    <link rel="shortcut icon" href="mazer-main/dist/assets/images/favicon.svg" type="image/x-icon">
    
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript" src="javascript/fucntions.js"></script>




</head>


<body>
    <div id="app">
        <div id="sidebar" class="active">
            <div class="sidebar-wrapper active">
                <div class="sidebar-header">
                    <div class="d-flex justify-content-between">
                        <div class="logo">
                            <a href="index.html"><img src="mazer-main/dist/assets/images/logo/logo.png" alt="Logo" srcset=""></a>
                        </div>
                        <div class="toggler">
                            <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                        </div>
                    </div>
                </div>
           
                
              <div class="sidebar-menu">
                    <ul class="menu">
                        <li class="sidebar-title">Menu</li>

                        <li class="sidebar-item active ">
                            <a href="dashboard.jsp" class='sidebar-link'>
                                <i class="bi bi-grid-fill"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>

                        <li class="sidebar-title">Forms &amp; Tables</li>

                        <li class="sidebar-item  ">
                            <a href="utilisateur.jsp" class='sidebar-link'>
                                <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>User Control</span>
                            </a>
                        </li>
                         <li class="sidebar-item  ">
                            <a href="Salle.jsp" class='sidebar-link'>
                                <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>Salle Controle</span>
                            </a>
                        </li>
                       
                        <li class="sidebar-item  ">
                            <a href="Reservation.jsp" class='sidebar-link'>
                                <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>Reservation  Controle </span>
                            </a>
                        </li>
                        
                       
                        <li class="sidebar-item  ">
                            <a href="Affichage.jsp" class='sidebar-link'>
                                <i class="bi bi-file-earmark-spreadsheet-fill"></i>
                                <span>Datatable</span>
                            </a>
                        </li>


                        <li class="sidebar-item  ">
                            <a href="Reservation.jsp">Apexcharts</a>
                        </li>
                    </ul>
                </div>
               
              
                <button class="sidebar-toggler btn x"><i data-feather="x"></i></button>
            </div>
        </div>
    
      </div>
    <script src="mazer-main/dist/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="mazer-main/dist/assets/js/bootstrap.bundle.min.js"></script>
    <script src="mazer-main/dist/assets/js/main.js"></script>
</body>

</html>