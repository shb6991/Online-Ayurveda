
<!-- Collect the nav links, forms, and other content for toggling -->

<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">

	<ul class="nav navbar-nav nav_1">
		<c:forEach items="${categories}" var="category">

			<li><a
				href="${contextRoot}/show/category/${category.id}/products"
				class="list-group-item" id="a_${category.name}">${category.name}</a></li>

		</c:forEach>
	</ul>

</div>
