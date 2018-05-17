/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties.

 Copyright (c) 1995-2017 NetCracker Technology Corp.

 All Rights Reserved.

*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package by.netcracker.zhuk.services.impl;

import by.netcracker.zhuk.entities.SpecialtyEntity;
import by.netcracker.zhuk.repository.SpecialtyRepository;
import by.netcracker.zhuk.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public List<SpecialtyEntity> getSpecialtiesByFacultyId(String facultyId) {
        return specialtyRepository.findSpecialtyByFacultyId(Integer.parseInt(facultyId));
    }

    @Override
    public SpecialtyEntity findById(Integer id) {
        return specialtyRepository.findById(id);
    }


    @Override
    public void addSpecialty(SpecialtyEntity specialtyEntity) {
        specialtyRepository.save(specialtyEntity);
    }

    @Override
    public List<SpecialtyEntity> findAll(){ return (List<SpecialtyEntity>) specialtyRepository.findAll();}

    @Override
    public SpecialtyEntity findByName(String name){return specialtyRepository.findByName(name);}
}