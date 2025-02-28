package com.DevSprint.LibraryMS.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DevSprint.LibraryMS.dto.MemberDTO;
import com.DevSprint.LibraryMS.exception.MemberNotFoundException;
import com.DevSprint.LibraryMS.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/members")
@RequiredArgsConstructor // constructor injection
public class MemberController {

    public final MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO) {
        if (memberDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.addMemeber(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam("memberId") String memberId) {
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            memberService.deleteMember(memberId);
            return ResponseEntity.noContent().build();
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO) {
        if (memberDTO == null || memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            memberService.updateMember(memberId, memberDTO);
            return ResponseEntity.noContent().build();
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable String memberId) {
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return ResponseEntity.ok(memberService.getMemberById(memberId));
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
