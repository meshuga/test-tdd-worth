package com.github.meshuga.wealth.service;

import com.github.meshuga.wealth.model.AssetType;
import com.github.meshuga.wealth.model.Worth;
import com.github.meshuga.wealth.repository.WorthRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorthServiceImplTest {

    @Mock
    private WorthRepository repository;

    @InjectMocks
    private WorthServiceImpl sut;

    @Test
    public void onEmptyPrintShouldReturnAnswer() {
        // WHEN
        var result = sut.printWorth();

        // THEN
        assertThat(result).contains("Net worth: 0");
    }

    @Test
    public void onOneAssetWealthPrintShouldReturnAnswer() {
        // GIVEN
        var worth = new Worth();
        worth.getAssets().put(AssetType.CHECKING_ACCOUNTS, 500.0);
        when(repository.get()).thenReturn(Optional.of(worth));

        // WHEN
        var result = sut.printWorth();

        // THEN
        verify(repository).get();
        assertThat(result).contains("Net worth: 500.00");
        assertThat(result).contains("Asset: Checking accounts, value: 500.00\n");
    }

    @Test
    public void onAddingNewAssetToNewWorthShouldAddNewAsset() {
        // GIVEN
        when(repository.get()).thenReturn(Optional.empty());

        when(repository.save(any())).thenAnswer(answer -> answer.getArgument(0));

        // WHEN
        var result = sut.addAsset(AssetType.CHECKING_ACCOUNTS, 500.0);

        // THEN
        verify(repository).get();
        verify(repository).save(any());
        Assertions.assertThat(result.getAssets()).containsKey(AssetType.CHECKING_ACCOUNTS);
    }

    @Test
    public void onAssetRemovalShouldRemoveAsset() {
        // GIVEN
        var worth = new Worth();
        worth.getAssets().put(AssetType.CHECKING_ACCOUNTS, 500.0);
        when(repository.get()).thenReturn(Optional.of(worth));

        when(repository.save(any())).thenAnswer(answer -> answer.getArgument(0));

        // WHEN
        var result = sut.removeAsset(AssetType.CHECKING_ACCOUNTS);

        // THEN
        Assertions.assertThat(result.getAssets()).isEmpty();
    }
}