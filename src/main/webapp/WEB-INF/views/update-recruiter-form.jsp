<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Recruiter Management</title>
	</head>
	<body>
	<div>
		<h2>Recruiter </h2>
		<h3>Update Recruiter</h3>
		<div>
			<div>
				<hr>
				<form:form action="saveRecruiter" modelAttribute="recruiter" method="POST">
					<form:hidden path="id"/>
					<div>
						<label for="companyName">Company Name: </label>
						<form:input path="companyName" name="companyName" />
						<form:errors path="companyName"/>
					</div>
                    <div>
						<label for="salary">Salary(In CTC): </label>
						<form:input type="number" path="salary" name="salary" step = "0.1" />
						<form:errors path="salary"/>
					</div>
					<div>
						<label for="jobDesignation">Job Designation: </label>
						<form:input path="jobDesignation" name="jobDesignation" />
						<form:errors path="jobDesignation"/>
					</div>
					<div>
						<label for="jobDescription">Job Description: </label>
						<form:textarea path="jobDescription" name="jobDescription" />
						<form:errors path="jobDescription"/>
					</div>
					<div>
						<label for="location">Place of joining: </label>
						<form:input path="location" name="location" />
						<form:errors path="location"/>
					</div>
					<div>
						<label for="eligibility">Eligibility: </label>
						<form:textarea path="eligibility" name="eligibility" />
						<form:errors path="eligibility"/>
					</div>

					<div>
						<label for="totalRequirement">No.  of Requirement: </label>
						<form:input type="number" path="totalRequirement" name="totalRequirement" />
						<form:errors path="totalRequirement"/>
					</div>

					<input type="submit" value="Save" class="btn btn-info btn-lg btn-block"/>
				</form:form>
			</div>
		</div>
		<a href="${pageContext.request.contextPath}/recruiter/list">Back to List</a>
	</div>
	</body>
</html>