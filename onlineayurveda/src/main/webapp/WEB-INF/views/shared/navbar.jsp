<!-- header -->
	<div class="agileits_header">
 		<div class="w3l_search">
			<form action="#" method="post">
				<input type="text" name="Product" value="Search a product..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search a product...';}">
				<input type="submit" value=" ">
			</form>
		</div>	
 	
	
<!-- 	<div class="product_list_header">  
			<form action="#" method="post" class="last">
                <fieldset>
                    <input type="hidden" name="cmd" value="_cart" />
                    <input type="hidden" name="display" value="1" />
                    <input type="submit" name="submit" value="View your cart" class="button" />
                </fieldset>
            </form>
		</div>   -->
		
		<div class="product_list_header float-right">
		<ul>
		<li class = "dropdown">
		
		<a href = "javascript:void(0)" class = "btn btn-warning btn-lg dropdown-toggle" id = "dropdownMenu1" data-toggle = "dropdown">
		
		${userModel.fullName} 
		<span class = "caret"></span>
		
		</a>
		
		<ul class = "dropdown-menu">
		
		<li>
		
		<a href = "${contextRoot}/cart">
		
		<span class ="glyphicon glyphicon-shopping-cart"></span>
		<span class = "badge">${userModel.cart.cartLines}</span>
		- &#8377; ${userModel.cart.grandTotal} 
		
		</a>
		
		</li>
		
		<li class = "divider" role = "separator"></li>
		
		<li>
		
		<a href = "${contextRoot}/logout">Logout</a>
		
		</li>
		
		</ul>
		
		</li>
		</ul>
		</div>
		
		<div class="w3l_header_right">
			<ul>
				<li class="dropdown profile_details_drop">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
					<div class="mega-dropdown-menu">
						<div class="w3ls_vegetables">
							<ul class="dropdown-menu drp-mnu">
								
								<!-- LOGIN -->
								
								<li id = "login">
								
								<a href = "${contextRoot}/login">Login</a>
								
								</li> 
								
								<!-- SIGNUP -->
								
								<li id = "register">
								
								<a href = "${contextRoot}/register">Sign Up</a>
								
									
							</ul>
						</div>                  
					</div>	
				</li>
			</ul>
		</div>
		<div class="w3l_header_right1">
			<h2><a href="mail.html">Contact Us</a></h2>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>

<div class="logo_products">
	<div class="container">
		<div class="w3ls_logo_products_left">
			<h1>
				<a href="${contextRoot}/home"><span>Swasthyam</span> Ayurveda</a>
			</h1>
		</div>
		<div class="w3ls_logo_products_left1">
			<ul class="special_items">
				<li><a href="events.html">Events</a><i>/</i></li>
				<li id="about"><a href="${contextRoot }/about">About Us</a><i>/</i></li>
				<li><a href="products.html">Best Deals</a><i>/</i></li>
				<li id="listProduct"><a
					href="${contextRoot}/show/all/products">View Products</a><i>/</i></li>

				<li id="manageProducts"><a
					href="${contextRoot}/manage/products">Manage products</a></li>
			</ul>
		</div>
		<div class="w3ls_logo_products_left1">
			<ul class="phone_email">
				<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234
					567</li>
				<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a
					href="mailto:store@grocery.com">store@grocery.com</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>