package com.match.game.facing.dao;

import com.match.game.facing.dto.FacingDto;

import java.util.List;

public interface FacingDao {
    public List<FacingDto> facing(String lolid);
    public void apply(FacingDto facingDto);
    public int facingNo(String lolid);
}
