<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Admin</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">	
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- owl stylesheets --> 
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

</head>
<body>
	<!--header section start -->
	<div class="header_section">
		<div class="container">
			<div class="row">
				<div class="col-sm-2">
					<!-- <div class="logo"><a href="index.html"><img src="images/logo.png"></a></div> -->
				</div>
				<div class="col-sm-6">
					<div class="menu-area">
                    <nav class="navbar navbar-expand-lg ">
                        <!-- <a class="navbar-brand" href="#">Menu</a> -->
                        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="home.html">Home</a> </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="users.php">Users</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="rescue.php">Rescue Team</a></li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="notifications.php">Notifications</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="complaints.php">Complaints</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="feedbacks.php">Feedbacks</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="restricted_areas.php">Restricted Areas</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="restricted_crossing.php">Restricted Crossings</a></li>
                            </ul>
                        </div>
                    </nav>
          </div>
				</div>
				
			</div>

    <div class="row">
      <div class="banner_section layout_padding">
      <section>
         <div id="main_slider" class="section carousel slide banner-main" data-ride="carousel">
            <div class="carousel-inner">
               <div class="carousel-item active">
                    <div class="container">
                     <div class="row marginii">
                        <div class="col-md-5 col-sm-12">
                           <div class="carousel-sporrt_text ">
                              <br><br>
                              <br><br>
                              <h1 class="banner_taital">Geofencing</h1>
                           </div>
                        </div>
                        <div class="col-md-7 col-sm-12">
                           <div class="img-box">
                              <figure><img src="images/banner-img1.png" style="max-width: 100%;"/></figure>
                           </div>
                        </div>
                    </div>
                  </div>
               </div>
               
            </div>
         </div>
      </section>
    </div>
    </div>

		</div>
        <!--header section end -->
        
		</div>
	</div>
    <!--banner section end -->




    <!--client section start -->
    <div class="clients_section layout_padding">
    	<div class="container">
    		<div class="row">
    		    <div class="col-sm-12">
    			    <div class="client_text"> <span style="color: #c6610f;">Add Notification</span></div>
    			    <br><br><br><br>
                    
                    <div class="enput_bt" style="margin-bottom: 50px">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input_main">
                            <div class="container">
                                <form action="add_notification.php" method="post">
                                    <div class="form-group">
                                    <input type="text" class="email-bt" placeholder="Title" name="title">
                                    </div>
                                    <div class="form-group">
                                    <input type="text" class="email-bt" placeholder="Notification" name="notification">
                                    </div>
                                    <div class="form-group">
                                    <input type="date" class="email-bt" placeholder="Date" name="date">
                                    </div>
                                    <div class="send_bt_main">
                                    <div class="left">
                                        <button type="submit" class="send_bt">SEND</button>
                                    </div>
                                </div>
                                <br><br>
                                </form>
                            </div> 
                            
                            </div>
                            </div>
                        </div>
                    </div>


                        <br><br><br>

    		    </div>
    	    </div>
    	</div>
    </div>
	<!--client section end -->



    

	<!--client section start -->
    <div class="clients_section layout_padding">
    	<div class="container">
    		<div class="row">
    		    <div class="col-sm-12">
    			    <div class="client_text"> <span style="color: #c6610f;">Notifications</span></div>
    			    <br><br><br><br>
                    
                    <table border="1" align="center"> 
                                <tr>
                                <td><h4>Title</h4></td>
                                <td><h4>Notification</h4></td>
								<td><h4>Date</h4></td>
								<td><h4>Delete</h4></td>
                                </tr>     
                                    
                                <?php
                                
                                include('config.php');
                                
                              	$query1="select * from notifications";
                    	        $res1=mysqli_query($conn, $query1) or die("error".mysqli_error());
                    	        
                    	        while($row1=mysqli_fetch_array($res1))
                    	        {
                        	        $id=$row1['id'];
                        	        $title=$row1['title'];
                        	        $notifications=$row1['notifications'];
                        	        $date=$row1['date'];
                                    ?>
                                
                                    <tr>
                                        <td><?php echo $title;?></td>
                                        <td><?php echo $notifications;?></td>
                                        <td><?php echo $date;?></td>
                                        <td><a href="delete_notification.php?id=<?php echo $id;?>"><li class="btn header-btn">Delete</li></a></td>
                                    </tr>
                                    <?php
                    	        }
                                ?>
                            
                            </table>


                        <br><br><br>

    		    </div>
    	    </div>
    	</div>
    </div>
	<!--client section end -->


	

      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <!-- javascript --> 
      <script src="js/owl.carousel.js"></script>
      <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
      <script>
         $(document).ready(function(){
         $(".fancybox").fancybox({
         openEffect: "none",
         closeEffect: "none"
         });
        
         </script>	


         <script>
      // This example adds a marker to indicate the position of Bondi Beach in Sydney,
      // Australia.
      function initMap() {
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 11,
          center: {lat: 40.645037, lng: -73.880224},
          });

        var image = 'images/location_point.png';
          var beachMarker = new google.maps.Marker({
             position: {lat: 40.645037, lng: -73.880224},
             map: map,
             icon: image
          });
        }
        </script>
        <!-- google map js -->
          <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8eaHt9Dh5H57Zh0xVTqxVdBFCvFMqFjQ&callback=initMap"></script>
        <!-- end google map js -->
</body>
</html>