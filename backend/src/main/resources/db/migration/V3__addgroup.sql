ALTER TABLE entrance_scores ADD COLUMN entrance_group varchar(10);

UPDATE entrance_scores
SET entrance_group = 'NATURAL'
WHERE vat_li IS NOT NULL OR hoa_hoc IS NOT NULL OR sinh_hoc IS NOT NULL;

UPDATE entrance_scores
SET entrance_group = 'SOCIAL'
WHERE lich_su IS NOT NULL OR dia_li IS NOT NULL OR gdcd IS NOT NULL;

UPDATE entrance_scores
SET entrance_group = 'COMMON'
WHERE entrance_group IS NULL;