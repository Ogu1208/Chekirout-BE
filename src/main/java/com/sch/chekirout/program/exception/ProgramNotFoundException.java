package com.sch.chekirout.program.exception;

import com.sch.chekirout.common.exception.CustomNotFoundException;

import static com.sch.chekirout.common.exception.ErrorCode.PROGRAM_NOT_FOUND;

public class ProgramNotFoundException extends CustomNotFoundException {

    public ProgramNotFoundException(final String programId) {
        super(String.format("프로그램을 찾을 수 없습니다. 프로그램 아이디 : %s", programId), PROGRAM_NOT_FOUND);
    }
}