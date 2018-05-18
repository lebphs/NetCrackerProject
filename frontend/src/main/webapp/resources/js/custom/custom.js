// $(document).ready(function () {
//     function getRequestFitDescriptionForAssign(idStudent) {
//         $.ajax({
//             url: 'requestsForDropdownAssign',
//             type: 'GET',
//             dataType: 'json',
//             contentType: "application/json",
//             mimeType: 'application/json',
//             data: {id: idStudent.toString()},
//             success: function (requests) {
//                 $(".jsRequestAssign").empty();
//                 requests ? function () {
//                     requests.some(function (request) {
//                         $(".jsRequestAssign").append('<option value=' + request.id + '>' + request.companyName + ' ' + request.availableQuantity + '</option>');
//                     });
//                 }() : false;
//             }
//         });
//     }
//
//     function getRequestFitDescriptionForRealise(idStudent) {
//         $.ajax({
//             url: 'requestsForDropdownRealise',
//             type: 'GET',
//             dataType: 'json',
//             contentType: "application/json",
//             mimeType: 'application/json',
//             data: {id: idStudent.toString()},
//             success: function (requests) {
//                 $(".jsRequestRealise").empty();
//                 requests ? function () {
//                     requests.some(function (request) {
//                         $(".jsRequestRealise").append('<option value=' + request.id + '>' + request.companyName + ' ' + request.availableQuantity + '</option>');
//                     });
//                 }() : false;
//             }
//         });
//     }
//
//     $(".jsRealiseOneStudent").click(function () {
//         var obj = {
//             studentsList: getIdSelections(),
//             requestsList: [$(".jsRequestRealise").find("option:selected").val()]
//         };
//         $.ajax({
//             url: 'realise-students',
//             type: 'POST',
//             dataType: 'json',
//             contentType: "application/json",
//             mimeType: 'application/json',
//             data: JSON.stringify(obj),
//             success: function (students) {
//                 $(".jsStudentPractices").bootstrapTable('load', students);
//             }
//         });
//     });
//
//     $(".jsAssignOneStudent").click(function () {
//         var obj = {
//             studentsList: getIdSelections(),
//             requestsList: [$(".jsRequestAssign").find("option:selected").val()]
//         };
//         $.ajax({
//             url: 'assignStudentPage',
//             type: 'POST',
//             dataType: 'json',
//             contentType: "application/json",
//             mimeType: 'application/json',
//             data: JSON.stringify(obj),
//             success: function (requests) {
//                 $(".jsStudentPractices").empty();
//                 requests ? function () {
//                     requests.some(function (request) {
//                         $(".jsStudentPractices").append("<tr><td>"+request.companyName+"</td><td>"+request.startDate+" - "+request.finishDate+"</td></tr>");
//                     });
//                 }() : false;
//             }
//
//         });
//     });
//
//     function getIdSelections() {
//         return [location.href.split("=")[1]];
//
//     }
//
//     $(".jsBtnAssignStudent").click(function () {
//         var idStudent = getIdSelections();
//         getRequestFitDescriptionForAssign(idStudent);
//     });
//
//     $(".jsBtnRealiseStudent").click(function () {
//         var idStudent = getIdSelections();
//         getRequestFitDescriptionForRealise(idStudent);
//     });
// });
//
