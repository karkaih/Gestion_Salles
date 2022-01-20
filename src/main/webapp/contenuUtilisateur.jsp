        <div id="main">
               <section id="multiple-column-form">
        <div class="row match-height">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Utilisateurs</h4>
                    </div>
                    
                    <div class="card-content">                   
                        <div class="card-body">
                           <input hidden type="text" id="iduser" class="form-control"
                                                placeholder="Username" name="fname-column">
                                <div class="row">
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="first-name-column">Username</label>
                                            <input type="text" id="username" class="form-control"
                                                placeholder="Username" name="fname-column">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="last-name-column">Password</label>
                                            <input type="text" id="password" class="form-control"
                                                placeholder="password" name="lname-column">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                        <label for="city-column">Level</label>
                                        
                                        <select class="form-control" name="pets" id="level">
                                              <option value="Admin">Admin</option>
   											  <option value="Client">Client</option>
  
                                         </select>
                                        
                                            
                                           
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                        
                                        
                                            <label for="country-floating">FullName</label>
                                            <input type="text" id="fullName" class="form-control"
                                                name="country-floating" placeholder="FullName">
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="email-id-column">Email</label>
                                            <input type="email" id="email" class="form-control"
                                                name="email-id-column" placeholder="Email">
                                        </div>
                                    </div>
                                    
                                      <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="email-id-column">City</label>
                                            <input type="text" id="city" class="form-control"
                                                name="email-id-column" placeholder="City">
                                        </div>
                                    </div>
                                    
                                      <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="email-id-column">State</label>
                                            <input type="text" id="state" class="form-control"
                                                name="email-id-column" placeholder="State">
                                        </div>
                                    </div>
                                 
                                    <div class="col-12 d-flex justify-content-end">
                                  
                                    <button id="createUser"   class="btn btn-primary me-1 mb-1" type="submit" >Create Account</button>
                                 
                                       
                                    </div>
                                </div>
                           
                        </div>
                    </div>
                </div>
                
                
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
                            <table class="table table-striped" >
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
                                        <th>Operations</th>
                                    </tr>
                                </thead>
                                <tbody id="UserTable">
                                
                                </tbody>
                            </table>
                        </div>
                    </div>

                </section>
            </div>
            </div>
        </div>
    </section>
    
    
</div>
