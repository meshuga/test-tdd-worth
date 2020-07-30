package com.github.meshuga.wealth.controller;

import com.github.meshuga.wealth.model.AssetType;
import com.github.meshuga.wealth.service.WorthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WorthControllerTest {

    @Mock
    private WorthService worthService;

    @InjectMocks
    private WorthController sut;

    @Test
    public void onPrintEmptyWorthShouldPrintNothing() {
        // WHEN
        sut.printWorth();

        // THEN
        verify(worthService).printWorth();
    }

    @Test
    public void onAddAssetShouldAddAsset() {
        // WHEN
        sut.addAsset(AssetType.CHECKING_ACCOUNTS, 500.0);

        // THEN
        verify(worthService).addAsset(AssetType.CHECKING_ACCOUNTS, 500.0);
    }

    @Test
    public void onRemoveAssetShouldRemoveAsset() {
        // WHEN
        sut.removeAsset(AssetType.CHECKING_ACCOUNTS);

        // THEN
        verify(worthService).removeAsset(AssetType.CHECKING_ACCOUNTS);
    }
}