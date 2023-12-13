<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Recruiter Management</title>
	</head>
	<body>
	<div>
		<h2><a href="${pageContext.request.contextPath}/recruiter/list">Insurance Policy List</a></h2>

		<input type="button" value="Add Recruiter" onclick="window.location.href='addRecruiterForm'; return false;"/>
        <form:form action="search" method="POST">
			<div>
			    <div>
			      <div><i aria-hidden="true"></i></div>
			    </div>
			    <input type="text" placeholder="Search By Name" name="theSearchName">
			    <input type="submit" value="Search"/>
			</div>
        </form:form>
		<table border="1">
			<tr>
				<th>#</th>
				<th>Company Name</th>
				<th>Salary(In CTC)</th>
				<th>Job Designation</th>
				<th>Job Description</th>
				<th>Place of joining</th>
				<th>Eligibility</th>
				<th>No. of Requirement</th>
				<th colspan="2">Action</th>
			</tr>
			<c:set var="index" value="0" />
			<c:forEach var="recruiter" items="${recruiters }">
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
	</body>
</html>