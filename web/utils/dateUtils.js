import { subMinutes } from 'date-fns'

// Mislim da treba pozivati samo kad se salje na back, ali nisam jos testirao
export const toUtcDate = (date) => subMinutes(date, date.getTimezoneOffset())

// Ovo je da bi prebacili ta polja u datume jer nisu datumi kad dodju na front
export const entityFieldsToDate = (entity) => {
  entity.availabilityStart = new Date(entity.availabilityStart)
  entity.availabilityEnd = new Date(entity.availabilityEnd)
  return entity
}

const dateUtils = { toUtcDate, entityFieldsToDate }

export default dateUtils
