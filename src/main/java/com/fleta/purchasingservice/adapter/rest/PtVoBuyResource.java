package com.fleta.purchasingservice.adapter.rest;

import com.fleta.purchasingservice.adapter.rest.errors.BadRequestAlertException;
import com.fleta.purchasingservice.domain.model.PtVoBuy;
import com.fleta.purchasingservice.port.JpaPtVoBuyRepository;
import com.megazone.framework.web.util.HeaderUtil;
import com.megazone.framework.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
public class PtVoBuyResource {

    private final Logger log = LoggerFactory.getLogger(PtVoBuyResource.class);

    private static final String ENTITY_NAME = "purchasingServicePtVoBuy";

    @Value("${mega.clientApp.name}")
    private String applicationName;

    private final JpaPtVoBuyRepository ptVoBuyRepository;

    public PtVoBuyResource(JpaPtVoBuyRepository ptVoBuyRepository) {
        this.ptVoBuyRepository = ptVoBuyRepository;
    }

    /**
     * {@code POST  /pt-vo-buys} : Create a new ptVoBuy.
     *
     * @param ptVoBuy the ptVoBuy to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ptVoBuy, or with status {@code 400 (Bad Request)} if the ptVoBuy has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pt-vo-buys")
    public ResponseEntity<PtVoBuy> createPtVoBuy(@Valid @RequestBody PtVoBuy ptVoBuy) throws URISyntaxException {
        log.debug("REST request to save PtVoBuy : {}", ptVoBuy);
        if (ptVoBuy.getSaId() != null) {
            throw new BadRequestAlertException("A new ptVoBuy cannot already have an ID", ENTITY_NAME, "idexists");

        }
        PtVoBuy savedItem = ptVoBuyRepository.save(ptVoBuy);
        if (savedItem != null) {
            return ResponseEntity.ok(savedItem);
        }
        return null;
    }

    /**
     * {@code PUT  /pt-vo-buys/:id} : Updates an existing ptVoBuy.
     *
     * @param id      the id of the ptVoBuy to save.
     * @param ptVoBuy the ptVoBuy to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ptVoBuy,
     * or with status {@code 400 (Bad Request)} if the ptVoBuy is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ptVoBuy couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/pt-vo-buys/{id}")
    public ResponseEntity<PtVoBuy> updatePtVoBuy(
            @PathVariable(value = "id", required = false) final Long id,
            @Valid @RequestBody PtVoBuy ptVoBuy
    ) throws URISyntaxException {
        log.debug("REST request to update PtVoBuy : {}, {}", id, ptVoBuy);
        if (ptVoBuy.getSaId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, ptVoBuy.getSaId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }
        Optional<PtVoBuy> existsItem = ptVoBuyRepository.findById(id);
        if (existsItem.isPresent()) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        return ResponseEntity.ok(ptVoBuyRepository.save(ptVoBuy));
    }

    /**
     * {@code PATCH  /pt-vo-buys/:id} : Partial updates given fields of an existing ptVoBuy, field will ignore if it is null
     *
     * @param id      the id of the ptVoBuy to save.
     * @param ptVoBuy the ptVoBuy to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ptVoBuy,
     * or with status {@code 400 (Bad Request)} if the ptVoBuy is not valid,
     * or with status {@code 404 (Not Found)} if the ptVoBuy is not found,
     * or with status {@code 500 (Internal Server Error)} if the ptVoBuy couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/pt-vo-buys/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<PtVoBuy> partialUpdatePtVoBuy(
            @PathVariable(value = "id", required = false) final Long id,
            @NotNull @RequestBody PtVoBuy ptVoBuy
    ) throws URISyntaxException {
        log.debug("REST request to partial update PtVoBuy partially : {}, {}", id, ptVoBuy);
        if (ptVoBuy.getSaId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, ptVoBuy.getSaId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }
        Optional<PtVoBuy> existsItem = ptVoBuyRepository.findById(id);
        if (existsItem.isEmpty()) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        Optional<PtVoBuy> optionalPtVoBuy = ptVoBuyRepository.findById(existsItem.get().getId());
        if (optionalPtVoBuy.isEmpty()) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        PtVoBuy existingPtVoBuy = optionalPtVoBuy.get();
        if (ptVoBuy.getSaId() != null) {
            existingPtVoBuy.setSaId(ptVoBuy.getSaId());
        }
        if (ptVoBuy.getMacAddr() != null) {
            existingPtVoBuy.setMacAddr(ptVoBuy.getMacAddr());
        }
        if (ptVoBuy.getBuyDate() != null) {
            existingPtVoBuy.setBuyDate(ptVoBuy.getBuyDate());
        }
        if (ptVoBuy.getProductId() != null) {
            existingPtVoBuy.setProductId(ptVoBuy.getProductId());
        }
        if (ptVoBuy.getProductName() != null) {
            existingPtVoBuy.setProductName(ptVoBuy.getProductName());
        }
        if (ptVoBuy.getPkgYn() != null) {
            existingPtVoBuy.setPkgYn(ptVoBuy.getPkgYn());
        }
        if (ptVoBuy.getGenreName() != null) {
            existingPtVoBuy.setGenreName(ptVoBuy.getGenreName());
        }
        if (ptVoBuy.getBuyAmt() != null) {
            existingPtVoBuy.setBuyAmt(ptVoBuy.getBuyAmt());
        }
        if (ptVoBuy.getCpUseYn() != null) {
            existingPtVoBuy.setCpUseYn(ptVoBuy.getCpUseYn());
        }
        if (ptVoBuy.getPvsTransYn() != null) {
            existingPtVoBuy.setPvsTransYn(ptVoBuy.getPvsTransYn());
        }
        if (ptVoBuy.getRefundYn() != null) {
            existingPtVoBuy.setRefundYn(ptVoBuy.getRefundYn());
        }
        if (ptVoBuy.getPvsTransNo() != null) {
            existingPtVoBuy.setPvsTransNo(ptVoBuy.getPvsTransNo());
        }
        if (ptVoBuy.getExpiredDate() != null) {
            existingPtVoBuy.setExpiredDate(ptVoBuy.getExpiredDate());
        }
        if (ptVoBuy.getAlwnceCharge() != null) {
            existingPtVoBuy.setAlwnceCharge(ptVoBuy.getAlwnceCharge());
        }
        if (ptVoBuy.getBalace() != null) {
            existingPtVoBuy.setBalace(ptVoBuy.getBalace());
        }
        if (ptVoBuy.getOfferCd() != null) {
            existingPtVoBuy.setOfferCd(ptVoBuy.getOfferCd());
        }
        if (ptVoBuy.getOfrSeq() != null) {
            existingPtVoBuy.setOfrSeq(ptVoBuy.getOfrSeq());
        }
        if (ptVoBuy.getErrorMsg() != null) {
            existingPtVoBuy.setErrorMsg(ptVoBuy.getErrorMsg());
        }
        if (ptVoBuy.getApplType() != null) {
            existingPtVoBuy.setApplType(ptVoBuy.getApplType());
        }
        PtVoBuy savedItem = ptVoBuyRepository.save(existingPtVoBuy);
        if (savedItem == null) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }
        return ResponseEntity.ok(ptVoBuyRepository.save(ptVoBuy));
    }

    /**
     * {@code GET  /pt-vo-buys} : get all the ptVoBuys.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ptVoBuys in body.
     */
    @GetMapping("/pt-vo-buys")
    public List<PtVoBuy> getAllPtVoBuys() {
        log.debug("REST request to get all PtVoBuys");
        return ptVoBuyRepository.findAll();
    }

    /**
     * {@code GET  /pt-vo-buys} : get all the ptVoBuys as a stream.
     *
     * @return the {@link List} of ptVoBuys.
     */
    @GetMapping(value = "/pt-vo-buys", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public List<PtVoBuy> getAllPtVoBuysAsStream() {
        log.debug("REST request to get all PtVoBuys as a stream");
        return ptVoBuyRepository.findAll();
    }

    /**
     * {@code GET  /pt-vo-buys/:id} : get the "id" ptVoBuy.
     *
     * @param id the id of the ptVoBuy to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ptVoBuy, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pt-vo-buys/{id}")
    public ResponseEntity<PtVoBuy> getPtVoBuy(@PathVariable Long id) {
        log.debug("REST request to get PtVoBuy : {}", id);
        Optional<PtVoBuy> ptVoBuy = ptVoBuyRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(ptVoBuy);
    }

    /**
     * {@code DELETE  /pt-vo-buys/:id} : delete the "id" ptVoBuy.
     *
     * @param id the id of the ptVoBuy to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/pt-vo-buys/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletePtVoBuy(@PathVariable Long id) {
        log.debug("REST request to delete PtVoBuy : {}", id);
        ptVoBuyRepository.deleteById(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
                .build();
    }
}