<?php

	include('config.php');

    $id=$_GET['id'];

$query="DELETE FROM notifications WHERE id='$id'";
$r=mysqli_query($conn, $query) or die("error in deletion".mysqli_error());

if($r)
{
    ?>
    <script language="javascript">alert('Deleted Successfully');
    window.location.replace('home.html');
    </script>
    <?php
}

else
{
    ?>
    <script language="javascript">alert('Failed To Delete');</script>
    <?php
}


?>