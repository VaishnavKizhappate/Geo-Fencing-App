<?php

	include('config.php');

$title = $_POST['title'];
$notification = $_POST['notification'];
$date = $_POST['date'];

$query="INSERT INTO notifications (title,notifications,date) VALUES('$title','$notification','$date')";
$r=mysqli_query($conn, $query) or die("error in deletion".mysqli_error());

if($r)
{
    ?>
    <script language="javascript">alert('Added Successfully');
    window.location.replace('home.html');
    </script>
    <?php
}

else
{
    ?>
    <script language="javascript">alert('Failed To Add');</script>
    <?php
}


?>