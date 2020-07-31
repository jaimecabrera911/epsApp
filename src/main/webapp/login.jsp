<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelado.Operaciones"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="resources/css/sb-admin-2.css" rel="stylesheet">
    </head>
    <body>
        <div class="bg-gradient-primary" style="height: 100vh">
            <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

              <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                  <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                      <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                      <div class="col-lg-6">
                        <div class="p-5" style="padding: 6rem 3rem !important;">
                          <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Bienvenido</h1>
                          </div>
                          <form class="user" action="login.jsp" id="basic-form" method="post">
                            <div class="form-group">
                                <input type="text" id="text" name="text" class="form-control form-control-user" placeholder="Ingrese su usuario"></input>
                            </div>
                            <div class="form-group">
                                <input type="password" id="password" name="password" class="form-control form-control-user" placeholder="Ingrese su contraseña"></input>
                            </div>
                              <!--
                            <div class="form-group">
                              <div class="custom-control custom-checkbox small">
                                  <input type="checkbox" class="custom-control-input" id="customCheck"></input>
                                <label class="custom-control-label" for="customCheck">Remember Me</label>
                              </div>
                            </div>
                              -->
                            <%
                                    Operaciones op = new Operaciones();
                                    if (request.getParameter("btnIngreso")!=null){
                                        String usuario=request.getParameter("text");
                                        String contra=request.getParameter("password");

                                        HttpSession sesion=request.getSession();

                                        switch(op.logueo(usuario, contra)){
                                            case 1:
                                            sesion.setAttribute("usuario", usuario);
                                            sesion.setAttribute("perfil", "1");
                                            request.getSession().setAttribute("usuario", usuario);
                                            response.sendRedirect("index.xhtml");    
                                        break;
                                            default:
                                            out.write("<div class='mensaje'>Usuario o contraseña inválida</div>");
                                        break;
                                        }
                                    }
                                %>
                                <input type="submit" name="btnIngreso" value="Ingresar" class="btn btn-primary btn-user btn-block">
                            <hr>
                            <!--<a href="#" class="btn btn-google btn-user btn-block">
                              <i class="fab fa-google fa-fw"></i> Ingresar con Google
                            </a>
                            <a href="#" class="btn btn-facebook btn-user btn-block">
                              <i class="fab fa-facebook-f fa-fw"></i> Ingresar con Facebook
                            </a>-->
                            
                            
                          </form>
                            <hr></hr>
                          <div class="text-center">
                            <a class="small" href="olvidoContrasena.xhtml">¿Olvide mi contraseña?</a>
                          </div>
                          <!--
                          <div class="text-center">
                            <a class="small" href="register.html">Create an Account!</a>
                          </div>
                          -->
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

              </div>

            </div>

          </div>
        </div>
      <!-- Bootstrap core JavaScript-->
      <script src="resources/vendor/jquery/jquery.min.js"></script>
      <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

      <!-- Core plugin JavaScript-->
      <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

      <!-- Custom scripts for all pages-->
      <script src="resources/js/sb-admin-2.min.js"></script>
    </body>
</html>
