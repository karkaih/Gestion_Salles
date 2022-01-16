
        <div id="main">
            <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>

            <div class="page-heading">
                <div class="page-title">
                    <div class="row">
                        <div class="col-12 col-md-6 order-md-1 order-last">
                            <h3>DataTable</h3>
                            <p class="text-subtitle text-muted">For user to check they list</p>
                        </div>
                        <div class="col-12 col-md-6 order-md-2 order-first">
                            <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="dashboard.jsp">Dashboard</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">DataTable</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
                <section class="section">
                    <div class="card">
                        <div class="card-header">
                            Simple Datatable
                        </div>
                        <div class="card-body">
                            <table class="table table-striped" id="UserTable">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>FullName</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                         <th>Email</th>
                                          <th>City</th>
                                        <th>State</th>
                                         <th>Level</th>
                                    </tr>
                                </thead>
                            </table>
                        </div>
                    </div>

                </section>
            </div>
        </div>
        
        <!-- <script type="text/javascript">
$.ajax({
    url: 'http://localhost:8081/Reserv_salles/UserController',
    dataType: 'json',
    success: function(data) {
        for (var i=0; i<data.length; i++) {
            var row = $('<tr><td>' + data[i].id+ '</td><td>' + data[i].fullname + '</td><td>' + data[i].username + '</td><td>'+ data[i].password + '</td><td>'+ data[i].email + '</td><td>'+ data[i].city + '</td><td>'+ data[i].state + '</td><td>'+ data[i].level + '</td></tr>');
            $('#UserTable').append(row);
        }
    },
    error: function(jqXHR, textStatus, errorThrown){
        alert('Error: ' + textStatus + ' - ' + errorThrown);
    }
});
</script> -->
