<div class="container">

	<!-- BreadCrumb -->
	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">HOME</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

	</div>

	<div class="row">


		<!-- for showing the peoduct image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images }/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>


		<!-- showing product description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description }</p>
			<hr />

			<h4>
				Price : <strong> &#8377; ${product.unitPrice } /-</strong>
			</h4>
			<hr />

			<h6>Qty. Available : ${product.quantity}</h6>
			<br />
			
			 <a href="${contextRoot }/cart/add/${product.id}/product"
				class="btn btn-success"><span
				class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a> <a
				href="${contextRoot }/show/all/products" class="btn btn-primary">Back</a>


		</div>

	</div>


</div>