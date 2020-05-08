$(document).ready(function () {
    $(".tab-content #edit_but").on('click', function (event) {
        event.preventDefault();
        var newEditForm = {
            name : $(this).closest('fieldset').find("input[name='name']").val(),
            id : $(this).closest('fieldset').find("input[name='id']").val(),
            street : $(this).closest('fieldset').find("input[name='street']").val(),
            age : $(this).closest('fieldset').find("input[name='age']").val(),
            role : $(this).closest('fieldset').find("input[name='role']").val(),
            password : $(this).closest('fieldset').find("input[name='password']").val(),
        };
        $.ajax({
            type: "POST",
            url: "/admin/editUser",
            contentType: "application/json",
            dataType: 'text',
            data: JSON.stringify(newEditForm),
            success: function (e) {
                console.log(newEditForm);
                window.location.href = "/admin/";
            },
            error: function (e) {
                console.log(newEditForm);
                window.location.href = "/admin/";
            },
        })
    });
    $(".tab-content #delete_but").on('click', function (event) {
        event.preventDefault();
        var delForm = {
            id : $(this).closest('fieldset').find("input[name='id']").val(),
            // id: $(this).attr('value')
        };
        $.ajax({
            type: "POST",
            url: "/admin/deleted",
            contentType: "application/json",
            dataType: 'text',
            data: JSON.stringify(delForm),
            success: function (e) {
                console.log(delForm);
                alert("User was deleted from database " + e);
            },
            error: function (e) {
                console.log(delForm);
                alert("Error in Delete " + e);
            },
        })
    });

    $("#callJSc").submit(function (event) {
        event.preventDefault();
        var addForm = {
            name: $("#name_create").val(),
            street: $("#street_create").val(),
            age: $("#age_create").val(),
            password: $("#passwordk").val(),
            role: $("#prava").val()
        };
        $.ajax({
            type: "POST",
            url: "/admin/addUser",
            contentType: "application/json",
            dataType: 'text',
            data: JSON.stringify(addForm),
            success: function (e) {
                alert("User was added in database" + e);
                window.location.href = "/admin/";
            },
            error: function (s) {
                alert("Error")
            },
        })
    });
    $.ajax({
        type: "get",
        url: "/admin/getUsers",
        contentType: "application/json",
        dataType: 'json',
        success: function (e) {
            var tbody = $('.tab-content .adminpage');
            $.each(e, function (i, w) {
                var page;
                page += '<tr>';
                page += '<td>' + w.id + '</td>';
                page += '<td>' + w.name + '</td>';
                page += '<td>' + w.street + '</td>';
                page += '<td>' + w.age + '</td>';
                page += '<td>' + w.role[0].name + '</td>';
                page += '<td>';
                page += '<button type="button" id="editButFor" class="bubu btn btn-info btn-lg btn-sm" data-toggle="modal" data-target="#editMod">Edit</button>';
                page += '</td>';
                page += '<td>';
                page += '<button id="callDeletePost" type="button" class="getIdinBut btn btn-danger btn-lg btn-sm" data-toggle="modal" data-target="#deleteMod">Delete</button>';
                page += ' </td>';
                tbody.append(page);
            });
            console.log(e);
        },
        error: function (e) {
            alert("bad");
            console.log(e);
        },
    });
    $(function() {
        var findUs = {
            id : $('#callJs').find("input[name='name']").val(),
        };
        $.ajax({
            type: "post",
            url: "/admin/findUser",
            contentType: "application/json",
            dataType: 'text',
            data: JSON.stringify(findUs),
            success: function (e) {
                var bbody = $('.tab-content .userpage');
                var page;
                page += '<tr>';
                page += '<td>' + e.id + '</td>';
                page += '<td>' + e.name + '</td>';
                page += '<td>' + e.street + '</td>';
                page += '<td>' + e.age + '</td>';
                page += '<td>' + e.role[0].name + '</td>';
                page += '<tr>';
                bbody.append(page);
                console.log(e);
            },
            error: function (e) {
                console.log(e);
            },
        });
    });
    $(document).on('click', '.bubu', function (e) {
        e.preventDefault();
        $('.tab-content #id_edit_form').val($(this).closest('tr').find('td:eq(0)').text());
        $('.tab-content #name').val($(this).closest('tr').find('td:eq(1)').text());
        $('.tab-content #street').val($(this).closest('tr').find('td:eq(2)').text());
        $('.tab-content #vozrast').val($(this).closest('tr').find('td:eq(3)').text());
        $('.tab-content #role').val($(this).closest('tr').find('td:eq(4)').text());
    });

    $(document).on('click', '.getIdinBut', function (e) {
        e.preventDefault();
        $('.tab-content #id_delete').val($(this).closest('tr').find('td:eq(0)').text());
        $('.tab-content #name_delete').val($(this).closest('tr').find('td:eq(1)').text());
        $('.tab-content #street_delete').val($(this).closest('tr').find('td:eq(2)').text());
        $('.tab-content #deletAge').val($(this).closest('tr').find('td:eq(3)').text());
        $('.tab-content #role_del').val($(this).closest('tr').find('td:eq(4)').text());
    });
});