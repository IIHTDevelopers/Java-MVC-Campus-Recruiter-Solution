<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Recruiter Management</title>
	</head>
	<body>
	<div>
		<h2><a href="${pageContext.request.contextPath}/recruiter/list">Recruiter List</a></h2>

		<input type="button" value="Add Recruiter" onclick="window.location.href='addRecruiterForm'; return false;"/>
        <form:form action="search" method="GET">
			<div>
			    <div>
			      <div><i aria-hidden="true"></i></div>
			    </div>
			    <input type="text" size = "30" placeholder="Search By Name/Required Experience" name="theSearchName">
			    <input type="submit" value="Search"/>
			</div>
        </form:form>
		<table border="1">
			<tr>
				<th>#</th>
				<th>Company Name
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=companyName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=companyName"> Asc </a> </th>
				<th>Salary(In CTC)
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=salary,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=salary"> Asc </a> </th>
				<th>Job Designation
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=jobDesignation,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=jobDesignation"> Asc </a> </th>
				<th>Job Description
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=jobDescription,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=jobDescription"> Asc </a> </th>
				<th>Place of joining
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=location,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=location"> Asc </a> </th>
				<th>Eligibility
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=eligibility,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=eligibility"> Asc </a> </th>
				</th>
				<th>Required Experience (In Years)
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=requiredExperience,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=requiredExperience"> Asc </a> </th>
				<th>No. of Requirement
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=totalRequirement,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=totalRequirement"> Asc </a> </th>
				<th colspan="2">Action</th>
			</tr>
			<c:set var="index" value="0" />
			<c:forEach var="recruiter" items="${recruiters}">
				<c:url var="updateLink" value="/recruiter/updateRecruiterForm">
					<c:param name="recruiterId" value="${recruiter.id}"></c:param>
				</c:url>

				<c:url var="deleteLink" value="/recruiter/delete">
					<c:param name="recruiterId" value="${recruiter.id}"></c:param>
				</c:url>

				<c:set var="index" value="${index + 1}" />
				<tr>
					<td>${index}</td>
					<td>${recruiter.companyName}</td>
					<td>${recruiter.salary} LPA</td>
					<td>${recruiter.jobDesignation}</td>
					<td>${recruiter.jobDescription}</td>
					<td>${recruiter.location}</td>
					<td>${recruiter.eligibility}</td>
					<td>${recruiter.requiredExperience}</td>
					<td>${recruiter.totalRequirement}</td>
					<td>
						<!-- display the update link -->
						<a href="${updateLink}">Update</a>
					</td>
					<td>
						<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this recruiter?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
            	<c:choose>
                    <c:when test="${totalPage <= 0}">
                        No Records Found
                    </c:when>
                    <c:otherwise>
                        <c:forEach begin="0" end="${totalPage-1}" varStatus="loop">
                            &nbsp;&nbsp;<a href="/list?page=${loop.index}&size=5&theSearchName=${theSearchName}&sort=${sortBy}">${loop.index + 1}</a>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
	
	</body>
</html>