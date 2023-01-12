package com.acem.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {

    // create roles -> POST
    /**
     * {
     *     "roleName": "LIBRARIAN"
     *     "authorities": {
     *          3,1,2
     *     }
     * }
     */
    // getAll roles -> GET
    /**
     * [
     *  {
     *     "roleName": "LIBRARIAN"
     *     "authorities": {
     *        "ISSUE_BOOK"
     *     }
     *  }
     * ]
     */
    // getRoleById -> GET
    /**
     *
     *  {
     *     "roleName": "LIBRARIAN"
     *     "authorities": {
     *        "ISSUE_BOOK"
     *     }
     *  }
     *
     */
    // update role -> PUT
    /**
     * {
     *     "id": 3
     *     "name": "LIBRARIAN"
     *     "authorities": {
     *          3,1
     *     }
     * }
     */
    // delete role -> DELETE /1

    // getAllAuthorities -> GET
    /**
     * [
     *  {
     *      "id": 1,
     *      "name": "CREATE_USER"
     *  }
     *  .
     *  .
     *  .
     * ]
     *
     *
     *
     */
}
