package com.jh.feelpotbackend.controller;

import com.jh.feelpotbackend.exception.ResourceNotFoundException;
import com.jh.feelpotbackend.model.Member;
import com.jh.feelpotbackend.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://silbioa480.github.io/")
@RestController
@RequestMapping("/api/")
public class MemberController {

  private final MemberRepository memberRepository;

  public MemberController(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @GetMapping("/members")
  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }

  @PostMapping("/members")
  public Member createMember(@RequestBody Member member) {
    return memberRepository.save(member);
  }

  @GetMapping("/members/{id}")
  public ResponseEntity<Member> getMemberById(@PathVariable String id) {
    Member member = memberRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Member not exist with id:" + id));

    return ResponseEntity.ok(member);
  }

  @PutMapping("/members/{id}")
  public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member changedMember) {
    Member member = memberRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Member not exist with id:" + id));

    member.setName(changedMember.getName());
    member.setPassword(changedMember.getPassword());
    member.setBirth(changedMember.getBirth());
    member.setIsMale(changedMember.getIsMale());
    member.setAddress(changedMember.getAddress());
    member.setEmail(changedMember.getEmail());
    member.setPhoneNumber(changedMember.getPhoneNumber());
    member.setIsAdmin(changedMember.getIsAdmin());
    member.setCart(changedMember.getCart());

    Member updateMember = memberRepository.save(member);

    return ResponseEntity.ok(updateMember);
  }

  @DeleteMapping("/members/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteMember(@PathVariable String id) {
    Member member = memberRepository.findById(id).
      orElseThrow(() -> new ResourceNotFoundException("Member not exist with id:" + id));

    memberRepository.delete(member);
    Map<String, Boolean> response = new HashMap<>();
    response.put("delete", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }
}
