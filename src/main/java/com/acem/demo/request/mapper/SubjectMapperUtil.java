package com.acem.demo.request.mapper;

import com.acem.demo.model.Subject;
import com.acem.demo.request.SubjectSaveRequest;
import com.acem.demo.request.SubjectUpdateRequest;
import com.acem.demo.utils.ModalMapperUtil;

public class SubjectMapperUtil {
        public static Subject mapSubject(SubjectSaveRequest subjectSaveRequest) {
            return ModalMapperUtil.map(subjectSaveRequest, Subject.class);
        }

        public static Subject mapSubject(SubjectUpdateRequest subjectUpdateRequest) {
            return ModalMapperUtil.map(subjectUpdateRequest, Subject.class);
        }
}
