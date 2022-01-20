        <div id="main">
               <section id="multiple-column-form">
        <div class="row match-height">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h4 class="card-title">Salles</h4>
                    </div>
                    <div class="card-content">
                        <div class="card-body">
                            <form class="form">
                                                            <div class="row">
                                                            
                                                            <input hidden type="text" id="idSalle" class="form-control"
                                                placeholder="Note" name="fname-column">
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="first-name-column">Name</label>
                                            <input type="text" id="name" class="form-control"
                                                placeholder="Name" name="fname-column">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="last-name-column">Capacity</label>
                                            <input type="text" id="capacity" class="form-control"
                                                placeholder="Capacity" name="lname-column">
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-12">
                                        <div class="form-group">
                                            <label for="city-column">Type</label>
                                            <input type="text" id="type" class="form-control" placeholder="Type"
                                                name="city-column">
                                        </div>
                                    </div>
                                
                                    
                                    </div>
                            <div class="col-12 d-flex justify-content-end">
                                        <button id="createSalle" type="submit" class="btn btn-primary me-1 mb-1">Create Salle</button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    
    
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
                                        <th>Name</th>
                                        <th>Capacity</th>
                                        <th>Type</th>
                                        <th>Operations</th>
                                        
                                    </tr>
                                </thead>
                                <tbody id="SalleTable">
                                
                                </tbody>
                            </table>
                            
                        </div>
                    </div>

                </section>
                
                
                
            </div>
    
    
    
    
    
    
           
        </div>
